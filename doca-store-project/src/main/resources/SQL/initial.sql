CREATE TABLE IF NOT EXISTS employee (
  employee_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  first_name varchar(45),
  last_name varchar(45),
  born_date date,
  phone_number varchar(20),
  email_address varchar(45),
  address varchar(45),
  administrator boolean,
  password varchar(100),
  registered_at timestamp,
  updated_at timestamp,
  employee_register_id int,
  employee_update_id int,
  FOREIGN KEY (employee_update_id) REFERENCES employee(employee_id),
  FOREIGN KEY (employee_register_id) REFERENCES employee(employee_id)
);

CREATE TABLE IF NOT EXISTS category_product (
  category_product_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  category_name varchar(45),
  registered_at timestamp,
  updated_at timestamp,
  employee_register_id int,
  employee_update_id int,
  FOREIGN KEY (employee_update_id) REFERENCES employee(employee_id),
  FOREIGN KEY (employee_register_id) REFERENCES employee(employee_id)
);

CREATE TABLE IF NOT EXISTS category_pet (
  category_pet_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  category_name varchar(45),
  registered_at timestamp,
  updated_at timestamp,
  employee_register_id int,
  employee_update_id int,
  FOREIGN KEY (employee_update_id) REFERENCES employee(employee_id),
  FOREIGN KEY (employee_register_id) REFERENCES employee(employee_id)
);

CREATE TABLE IF NOT EXISTS product (
  product_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  product_name varchar(45),
  unit_price decimal(10,2),
  category_product_id int,
  category_pet_id int,
  image varchar(100),
  registered_at timestamp,
  updated_at timestamp,
  employee_register_id int,
  employee_update_id int,
  FOREIGN KEY (employee_register_id) REFERENCES employee(employee_id),
  FOREIGN KEY (employee_update_id) REFERENCES employee(employee_id),
  FOREIGN KEY (category_product_id) REFERENCES category_product(category_product_id),
  FOREIGN KEY (category_pet_id) REFERENCES category_pet(category_pet_id)
);

CREATE TABLE IF NOT EXISTS stock (
  product_id int NOT NULL PRIMARY KEY,
  quantity int,
  registered_at timestamp,
  updated_at timestamp,
  employee_register_id int,
  employee_update_id int,
  FOREIGN KEY (employee_register_id) REFERENCES employee(employee_id),
  FOREIGN KEY (product_id) REFERENCES product(product_id),
  FOREIGN KEY (employee_update_id) REFERENCES employee(employee_id)
);

CREATE TABLE IF NOT EXISTS customer (
  customer_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  first_name varchar(45),
  last_name varchar(45),
  born_date date,
  phone_number varchar(20),
  email_address varchar(45),
  address varchar(45),
  password varchar(100),
  registered_at timestamp,
  updated_at timestamp
);

CREATE TABLE IF NOT EXISTS cart_order (
  cart_order_id int NOT NULL PRIMARY KEY,
  customer_id int,
  ordered_at timestamp,
  total decimal(10,2),
  FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
);

CREATE TABLE IF NOT EXISTS buying_history (
  cart_order_id int NOT NULL PRIMARY KEY,
  customer_id int,
  ordered_at timestamp,
  purchased_at timestamp,
  total decimal(10,2)
);

CREATE TABLE IF NOT EXISTS cart_order_detail (
  cart_order_detail_id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  cart_order_id int,
  product_id int,
  ordered_at timestamp,
  unit_price decimal(10,2),
  quantity int,
  FOREIGN KEY (cart_order_id) REFERENCES cart_order(cart_order_id),
  FOREIGN KEY (product_id) REFERENCES product(product_id),
  FOREIGN KEY (cart_order_id) REFERENCES buying_history(cart_order_id)
);

CREATE TABLE IF NOT EXISTS credit_card (
  credit_card_id int NOT NULL PRIMARY KEY,
  cvv_cvc int,
  good_thru date,
  customer_id int,
  FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
);