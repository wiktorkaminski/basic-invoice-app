INSERT INTO addresses (id, city, country, property, street, zip_code) VALUES (1, 'Tychy', 'Polska', '233/2', 'Puszkina', '43-100');
INSERT INTO addresses (id, city, country, property, street, zip_code) VALUES (2, 'Katowice', 'Polska', '23/99', 'Kolberga', '40-203');
INSERT INTO addresses (id, city, country, property, street, zip_code) VALUES (3, 'Jaworzno', 'Polska', '1', 'Kukuczki', '32-333');
INSERT INTO addresses (id, city, country, property, street, zip_code) VALUES (4, 'Nosaczowo', 'Polska', '12/3', 'Pana Jana', '43-200');
INSERT INTO addresses (id, city, country, property, street, zip_code) VALUES (5, 'Januszowo', 'Polska', '4', 'Moja', '40-001');
INSERT INTO addresses (id, city, country, property, street, zip_code) VALUES (6, 'Tychy', 'Polska', '33', 'Kolberga', '43-100');

INSERT INTO users (id, authority, enabled, first_name, last_name, password, username, company_id) VALUES (2, 'ROLE_USER', true, 'Aldona', 'Dretwiak', '$2a$10$0avJhYgKsQYAdnKBj1sti.VxQYlj7drVPtmD7sPfvN..hsvCfrJ0.', 'qaz@o2.pl', null);
INSERT INTO users (id, authority, enabled, first_name, last_name, password, username, company_id) VALUES (3, 'ROLE_USER', true, 'Lola', 'Trendy', '$2a$10$f8yEAXnt1jCQcxNy.pf9BegKqr2PDMqRafGzmwrwqhu6OiRdS9Kh6', 'zaq@o2.pl', null);

INSERT INTO contractors (id, email, name, nip, phone, regon, short_name, website, address_id, owner_id) VALUES (2, 'wow@o2.pl', 'Wow sp. z o.o.', '6949150591', '664-567-090', '526263436', 'Wow', 'www.wow.nazwa.pl', 1, 2);
INSERT INTO contractors (id, email, name, nip, phone, regon, short_name, website, address_id, owner_id) VALUES (3, 'albin@o2.pl', 'Albin Kolano', '2361258347', '323-111-230', '017892293', 'AlKo', 'www.alko.com', 2, 2);
INSERT INTO contractors (id, email, name, nip, phone, regon, short_name, website, address_id, owner_id) VALUES (4, 'aldona@gmail.com', 'Aldi s.c.', '4708273701', '888-888-108', '482415472', 'Aldi', 'www.aldi.post.pl', 3, 2);
INSERT INTO contractors (id, email, name, nip, phone, regon, short_name, website, address_id, owner_id) VALUES (5, 'office@aldre.com', 'Aldre sp. z o.o.', '5313319124', '523-333-211', '8987298', 'Aldre', 'www.aldre.online', 4, 2);
INSERT INTO contractors (id, email, name, nip, phone, regon, short_name, website, address_id, owner_id) VALUES (6, '', 'Lotre sp. z o.o.', '6462685202', '32-323-12-13', '390898094', 'Lotre', 'http://www.example.com', 5, 3);
INSERT INTO contractors (id, email, name, nip, phone, regon, short_name, website, address_id, owner_id) VALUES (7, 'example@exe.com', 'Exampler Inc', '3774347212', '32-323-12-13', '497335528', 'Example', '', 6, 3);

UPDATE users SET company_id=5 WHERE users.id = 2;
UPDATE users SET company_id=6 WHERE users.id = 3;

INSERT INTO invoice_contractor (id, city, country, email, name, nip, phone, property, regon, short_name, street, zip_code) VALUES (1, 'Nosaczowo', 'Polska', 'office@aldre.com', 'Aldre sp. z o.o.', '5313319124', '523-333-211', '12/3', '8987298', 'Aldre', 'Pana Jana', '43-200');
INSERT INTO invoice_contractor (id, city, country, email, name, nip, phone, property, regon, short_name, street, zip_code) VALUES (2, 'Tychy', 'Polska', 'wow@o2.pl', 'Wow sp. z o.o.', '6949150591', '664-567-090', '233/2', '526263436', 'Wow', 'Puszkina', '43-100');
INSERT INTO invoice_contractor (id, city, country, email, name, nip, phone, property, regon, short_name, street, zip_code) VALUES (3, 'Nosaczowo', 'Polska', 'office@aldre.com', 'Aldre sp. z o.o.', '5313319124', '523-333-211', '12/3', '8987298', 'Aldre', 'Pana Jana', '43-200');
INSERT INTO invoice_contractor (id, city, country, email, name, nip, phone, property, regon, short_name, street, zip_code) VALUES (4, 'Katowice', 'Polska', 'albin@o2.pl', 'Albin Kolano', '2361258347', '323-111-230', '23/99', '017892293', 'AlKo', 'Kolberga', '40-203');
INSERT INTO invoice_contractor (id, city, country, email, name, nip, phone, property, regon, short_name, street, zip_code) VALUES (5, 'Januszowo', 'Polska', '', 'Lotre sp. z o.o.', '6462685202', '32-323-12-13', '4', '390898094', 'Lotre', 'Moja', '40-001');
INSERT INTO invoice_contractor (id, city, country, email, name, nip, phone, property, regon, short_name, street, zip_code) VALUES (6, 'Tychy', 'Polska', 'example@exe.com', 'Exampler Inc', '3774347212', '32-323-12-13', '33', '497335528', 'Example', 'Kolberga', '43-100');
INSERT INTO invoice_contractor (id, city, country, email, name, nip, phone, property, regon, short_name, street, zip_code) VALUES (7, 'Januszowo', 'Polska', '', 'Lotre sp. z o.o.', '6462685202', '32-323-12-13', '4', '390898094', 'Lotre', 'Moja', '40-001');
INSERT INTO invoice_contractor (id, city, country, email, name, nip, phone, property, regon, short_name, street, zip_code) VALUES (8, 'Tychy', 'Polska', 'example@exe.com', 'Exampler Inc', '3774347212', '32-323-12-13', '33', '497335528', 'Example', 'Kolberga', '43-100');

INSERT INTO invoice_product (id, name, price, quantity, units, vat_rate) VALUES (1, 'Computer service', 280, 1, 'service', 23);
INSERT INTO invoice_product (id, name, price, quantity, units, vat_rate) VALUES (2, 'Parts', 29.8, 10, 'psc', 5);
INSERT INTO invoice_product (id, name, price, quantity, units, vat_rate) VALUES (3, 'Parts', 9.99, 122, 'psc', 23);
INSERT INTO invoice_product (id, name, price, quantity, units, vat_rate) VALUES (4, 'Shipping', 45, 1, 'service', 8);
INSERT INTO invoice_product (id, name, price, quantity, units, vat_rate) VALUES (5, 'Packing', 19.9, 1, 'service', 0);
INSERT INTO invoice_product (id, name, price, quantity, units, vat_rate) VALUES (6, 'Apples', 0.8, 784, 'psc', 5);

INSERT INTO invoice_product_list (id) VALUES (1);
INSERT INTO invoice_product_list (id) VALUES (2);
INSERT INTO invoice_product_list (id) VALUES (3);

INSERT INTO invoice_product_list_product_list (invoice_product_list_id, product_list_id) VALUES (1, 1);
INSERT INTO invoice_product_list_product_list (invoice_product_list_id, product_list_id) VALUES (1, 2);
INSERT INTO invoice_product_list_product_list (invoice_product_list_id, product_list_id) VALUES (2, 3);
INSERT INTO invoice_product_list_product_list (invoice_product_list_id, product_list_id) VALUES (2, 4);
INSERT INTO invoice_product_list_product_list (invoice_product_list_id, product_list_id) VALUES (2, 5);
INSERT INTO invoice_product_list_product_list (invoice_product_list_id, product_list_id) VALUES (3, 6);

INSERT INTO invoiceApp.invoice_symbol (id, invoice_number, owner_id) VALUES (2, 2, 2);
INSERT INTO invoiceApp.invoice_symbol (id, invoice_number, owner_id) VALUES (3, 1, 3);

INSERT INTO invoiceApp.invoices (id, amount_paid, created_on, notes, payment_date, sale_date, symbol, updated_on, buyer_id, invoice_product_list_id, user_id, seller_id) VALUES (1, 100, '2020-12-13 13:29:19.231691', 'Service Rozdzienskiego str. 90', '2020-12-23', '2020-12-12', '1-12-2020', null, 2, 1, 2, 1);
INSERT INTO invoiceApp.invoices (id, amount_paid, created_on, notes, payment_date, sale_date, symbol, updated_on, buyer_id, invoice_product_list_id, user_id, seller_id) VALUES (2, 199, '2020-12-13 13:30:48.734732', '', '2021-01-23', '2020-12-12', '2-12-2020', null, 4, 2, 2, 3);
INSERT INTO invoiceApp.invoices (id, amount_paid, created_on, notes, payment_date, sale_date, symbol, updated_on, buyer_id, invoice_product_list_id, user_id, seller_id) VALUES (3, 0, '2020-12-13 13:40:53.158872', '', '2020-12-18', '2020-12-12', '1-12-2020', null, 8, 3, 3, 7);
