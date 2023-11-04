*******   How To RUN Microservices  **********

1) when you open spring boot microservices application first time please build 
all microservices one by one for creating jar files (it may not be build) from gradle

2) creating images and put them into your docker hub (remember that writing these codes )
	docker build -t user-ms-image:latest .
	docker build -t product-ms-image:latest .
	docker build -t card-ms-image:latest .
	docker build -t payment-ms-image:latest .
(remember that, writing these codes in terminal which is located in that microservices)

3) After you see the built images on your docker desktop run 
	docker-compose up

4) Already Our microservices ready to handle requests
	