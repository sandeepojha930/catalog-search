DROP TABLE IF EXISTS PRODUCT;
DROP TABLE IF EXISTS SELLER;
-- Creating the seller table
CREATE TABLE seller (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255) NOT NULL
);

--Creating the product table
CREATE TABLE product(
id BIGINT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255) NOT NULL,
category VARCHAR(10) NOT NULL,
brand VARCHAR(100) NOT NULL,
price DECIMAL(10,2) NOT NULL,
color VARCHAR(50),
size VARCHAR(20),
sku VARCHAR(50) UNIQUE NOT NULL,
avl_qty INT NOT NULL,
seller_id BIGINT,
FOREIGN KEY(seller_id) REFERENCES seller(id)
);