
INSERT INTO `addresses` VALUES (1,'Tychy','Polska','233/2','Puszkina','43-100');
INSERT INTO `addresses` VALUES (2,'Katowice','Polska','23/99','Kolberga','40-203');
INSERT INTO `addresses` VALUES (3,'Jaworzno','Polska','1','Kukuczki','32-333');
INSERT INTO `addresses` VALUES (4,'Nosaczowo','Polska','12/3','Pana Jana','43-200');

INSERT INTO `users` VALUES (1,'ROLE_USER', true ,'Jan','Marian','$2a$10$0avJhYgKsQYAdnKBj1sti.VxQYlj7drVPtmD7sPfvN..hsvCfrJ0.','aka@o2.pl',NULL);
INSERT INTO `users` VALUES (2,'ROLE_USER', true ,'Aldona','Dretwiak','$2a$10$0avJhYgKsQYAdnKBj1sti.VxQYlj7drVPtmD7sPfvN..hsvCfrJ0.','qaz@o2.pl',NULL);

INSERT INTO `contractors` VALUES (2,'wow@o2.pl','Wow sp. z o.o.','6949150591','664-567-090','526263436','Wow','www.wow.nazwa.pl',1,2);
INSERT INTO `contractors` VALUES (3,'albin@o2.pl','Albin Kolano','2361258347','323-111-230','017892293','AlKo','www.alko.com',2,2);
INSERT INTO `contractors` VALUES (4,'aldona@gmail.com','Aldi s.c.','4708273701','888-888-108','482415472','Aldi','www.aldi.post.pl',3,2);
INSERT INTO `contractors` VALUES (5,'office@aldre.com','Aldre sp. z o.o.','5313319124','523-333-211','8987298','Aldre','www.aldre.online',4,2);

UPDATE users SET company_id=5 WHERE users.id = 2;

INSERT INTO `invoice_contractor` VALUES (1,'Katowice','Polska','aldi@post.pl','Aldona s.c.','6754850582','32 324-32-22','37/40','267093954','AlDi','Kolberga','40-203');
INSERT INTO `invoice_contractor` VALUES (2,'Katowice','Polska','albin@post.pl','Albin Kolano sp. z.o.o.','7245632713','666-888-000','1a/7','578726284','Albin','Uszatki','40-203');

INSERT INTO `invoice_product` VALUES (1,'Service',100,1,'set',23);
INSERT INTO `invoice_product` VALUES (2,'Parts',1240.6,2,'set',23);

INSERT INTO `invoice_product_list` VALUES (1);

INSERT INTO `invoice_product_list_product_list` VALUES (1,1);
INSERT INTO `invoice_product_list_product_list` VALUES (1,2);

INSERT INTO `invoice_symbol` VALUES (2,0,2);


INSERT INTO `invoices` VALUES (1,0,'2020-12-01 14:27:08.000000','Computer service on Rozdzienskiego Street 222','2021-01-31','2020-12-01','1/11/2020',NULL,1,1,1,2);
INSERT INTO `invoices` VALUES (1,0,'2020-12-01 14:27:08.000000','Computer service on Rozdzienskiego Street 222','2021-01-31','2020-12-01','1/11/2020',NULL,1,1,1,2);
INSERT INTO `invoices` VALUES (1,0,'2020-12-01 14:27:08.000000','Computer service on Rozdzienskiego Street 222','2021-01-31','2020-12-01','1/11/2020',NULL,1,1,2,2);

