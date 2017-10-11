CREATE TABLE category(
   id int(6) AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50),
  description VARCHAR(255),
  image_url VARCHAR(100),
  is_active boolean);
 
  
 
 INSERT INTO category(name,description,image_url,is_active) 
 VALUES("Laptop","This is an Laptop Category","1.png",true);
  

 INSERT INTO category(name,description,image_url,is_active) 
 VALUES("Television","This is an Televion Category","2.png",true);
  
 
 INSERT INTO category(name,description,image_url,is_active) 
 VALUES("Mobile","This is an Mobile Category","3.png",true);
  
  
  
CREATE TABLE user_detail(
   id INT(6) AUTO_INCREMENT PRIMARY KEY,
   first_name VARCHAR(50),
   last_name VARCHAR(50),
   role VARCHAR(50),
   enabled BOOLEAN,
   password VARCHAR(50),
   email VARCHAR(50),
   contact_number VARCHAR(15));

   
 INSERT INTO user_detail(first_name,last_name,role,enabled,password,email,contact_number)
 VALUES("rakesh","lohar","ADMIN",true,"admin","rakeshlohar@live.com","9819582996");
 
 INSERT INTO user_detail(first_name,last_name,role,enabled,password,email,contact_number)
 VALUES("ritesh","pathak","SUPPLIER",true,"supplier","riteshpatha@gmail.com","9819582936");
 
 INSERT INTO user_detail(first_name,last_name,role,enabled,password,email,contact_number)
 VALUES("Prajesh","Talpade","SUPPLIER",true,"supplier","pjtalpade@live.com","9819582996");
 
 CREATE TABLE product(
   id INT(5) AUTO_INCREMENT PRIMARY KEY,
   code VARCHAR(20),
   name VARCHAR(50),
   brand VARCHAR(50),
   description VARCHAR(255),
   unit_price DECIMAL(10,2),
   quantity INT,
   is_active BOOLEAN,
   category_id INT,
   supplier_id INT,
   purchases INT DEFAULT 0,
   views INT DEFAULT 0,
   FOREIGN KEY(category_id) REFERENCES category(id),
   FOREIGN KEY(supplier_id) REFERENCES user_detail(id)
 );
 
 
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDABC123DEFX', 'iPhone 5s', 'apple', 'This is one of the best phone available in the market right now!', 18000, 5, true, 3, 2 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDDEF123DEFX', 'Samsung s7', 'samsung', 'A smart phone by samsung!', 32000, 2, true, 3, 3 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDPQR123WGTX', 'Google Pixel', 'google', 'This is one of the best android smart phone available in the market right now!', 57000, 5, true, 3, 2 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDMNO123PQRX', ' Macbook Pro', 'apple', 'This is one of the best laptops available in the market right now!', 54000, 3, true, 1, 2 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDABCXYZDEFX', 'Dell Latitude E6510', 'dell', 'This is one of the best laptop series from dell that can be used!', 48000, 5, true, 1, 3 );