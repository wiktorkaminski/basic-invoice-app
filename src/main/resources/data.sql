INSERT INTO addresses (id, city, country, property, street, zip_code) VALUES (1, 'Tychy', 'Polska', '233/2', 'Puszkina', '43-100');
INSERT INTO addresses (id, city, country, property, street, zip_code) VALUES (2, 'Katowice', 'Polska', '23/99', 'Kolberga', '40-203');
INSERT INTO addresses (id, city, country, property, street, zip_code) VALUES (3, 'Jaworzno', 'Polska', '1', 'Kukuczki', '32-333');


INSERT INTO contractors (id, email, name, nip, phone, regon, short_name, website, address_id, owner_id) VALUES (2, 'wow@o2.pl', 'Wow sp. z o.o.', '6949150591', '664-567-090', '526263436', 'Wow', 'www.wow.nazwa.pl', 1, null);
INSERT INTO contractors (id, email, name, nip, phone, regon, short_name, website, address_id, owner_id) VALUES (3, 'albin@o2.pl', 'Albin Kolano', '2361258347', '323-111-230', '017892293', 'AlKo', 'www.alko.com', 2, null);
INSERT INTO contractors (id, email, name, nip, phone, regon, short_name, website, address_id, owner_id) VALUES (4, 'aldona@gmail.com', 'Aldi s.c.', '4708273701', '888-888-108', '482415472', 'Aldi', 'www.aldi.post.pl', 3, null);


INSERT INTO invoice_contractor (id, city, country, email, name, nip, phone, property, regon, short_name, street, zip_code) VALUES (1, 'Katowice', 'Polska', 'aldi@post.pl', 'Aldona s.c.', '6754850582', '32 324-32-22', '37/40', '267093954', 'AlDi', 'Kolberga', '40-203');
INSERT INTO invoice_contractor (id, city, country, email, name, nip, phone, property, regon, short_name, street, zip_code) VALUES (2, 'Katowice', 'Polska', 'albin@post.pl', 'Albin Kolano sp. z.o.o.', '7245632713', '666-888-000', '1a/7', '578726284', 'Albin', 'Uszatki', '40-203');


INSERT INTO invoice_product (id, name, price, quantity, units, vat_rate) VALUES (1, 'Service', 100, 1, 'set', 23);
INSERT INTO invoice_product (id, name, price, quantity, units, vat_rate) VALUES (2, 'Parts', 1240.6, 2, 'set', 23);


INSERT INTO invoice_product_list (id) VALUES (1);


INSERT INTO invoice_product_list_product_list (invoice_product_list_id, product_list_id) VALUES (1, 1);
INSERT INTO invoice_product_list_product_list (invoice_product_list_id, product_list_id) VALUES (1, 2);

INSERT INTO invoices (id, amount_paid, created_on, notes, payment_date, sale_date, symbol, updated_on, buyer_id, invoice_product_list_id, user_id, seller_id) VALUES (1, 0, '2020-12-01 14:27:08', 'Computer service on Rozdzienskiego Street 222', '2021-01-31', '2020-12-01', '0/2020', null, 1, 1, null, 2);
INSERT INTO users (id, username, first_name, last_name, password, company_id, authority, enabled) VALUES (1, 'aka@o2.pl', 'Jan', 'Marian', '1234', null, 'ROLE_USER', true);

INSERT INTO invoiceApp.invoice_symbol (id, invoice_number, owner_id) VALUES (2, 0, 1);


