package az.azericard.userms.service;

import az.azericard.userms.domain.Product;
import az.azericard.userms.domain.Transaction;
import az.azericard.userms.domain.UserCard;
import az.azericard.userms.dto.PaymentDto;
import az.azericard.userms.dto.PurchaseDto;
import az.azericard.userms.dto.TransactionDto;
import az.azericard.userms.exception.CardBalanceNotEnoughException;
import az.azericard.userms.exception.ProductCountMoreThanStockException;
import az.azericard.userms.exception.ResourceNotFoundException;
import az.azericard.userms.repo.CardRepo;
import az.azericard.userms.repo.ProductRepo;
import az.azericard.userms.repo.TransactionRepo;
import az.azericard.userms.utils.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepo transactionRepo;
    private final ProductRepo productRepo;
    private final CardRepo cardRepo;
    public List<TransactionDto> getUserTransactionHistory(Long userId) {
        List<Transaction> transactions = transactionRepo.findAllByUserId(userId);
        return Mapper.mapAll(transactions, TransactionDto.class);
    }

    @Transactional
    public PaymentDto makePurchase(PurchaseDto purchaseDto) {
        Product product = productRepo.findById(purchaseDto.getProductId()).orElseThrow(() -> new ResourceNotFoundException("Product Not Found"));
        UserCard card = cardRepo.findById(purchaseDto.getCardId()).orElseThrow(() -> new ResourceNotFoundException("Card Not Found"));
        Long count = purchaseDto.getProductCount();

        //check product count in stock
        boolean productIsEnough = (product.getStock() - count) >= 0;

        //Calculate amount
        BigDecimal amount = new BigDecimal(count.toString()).multiply(product.getPrice());

        //Check Card Balance with calculated amount
        boolean cardBalanceIsEnough = card.getBalance().compareTo(amount) >= 0;

        if(productIsEnough){
            if (cardBalanceIsEnough){
                //make purchase
            }else
                throw new CardBalanceNotEnoughException("Card balance not enough exception");
        }else
            throw new ProductCountMoreThanStockException("Product count more than stock exception");

        return new PaymentDto();
    }

}
