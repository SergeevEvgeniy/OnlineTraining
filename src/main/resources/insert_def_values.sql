-- Filling Table UserRole
INSERT INTO userrole VALUES (1, 'student');
INSERT INTO userrole VALUES (2, 'lector');
INSERT INTO userrole VALUES (3, 'admin');

-- Filling Table User
INSERT INTO "PUBLIC"."USER" VALUES (1, 'user1@a.ru', 'Sam', 'sam', 1);
INSERT INTO "PUBLIC"."USER" VALUES (2, 'user2@a.ru', 'Lola', 'lola', 1);
INSERT INTO "PUBLIC"."USER" VALUES (3, 'lector1@a.ru', 'Obi Wan', 'ben', 2);
INSERT INTO "PUBLIC"."USER" VALUES (4, 'lector2@a.ru', 'Yoda', 'master', 2);
INSERT INTO "PUBLIC"."USER" VALUES (5, 'admin@a.ru', 'admin', 'admin', 3);

-- Filling Table Course
INSERT INTO "PUBLIC".COURSE VALUES (1,'Reading','Reading literature',3);
INSERT INTO "PUBLIC".COURSE VALUES (2,'Writing','Writing essays',3);
INSERT INTO "PUBLIC".COURSE VALUES (3,'Scream','Stress reducing',4);
INSERT INTO "PUBLIC".COURSE VALUES (4,'Hacking','IT courses',4);
INSERT INTO "PUBLIC".COURSE VALUES (5,'Rest','moment of rest',3);

-- Filling Table Task
INSERT INTO "PUBLIC".TASK VALUES (1,'read the poem', 'read the poem of at least 100 pages', 1);
INSERT INTO "PUBLIC".TASK VALUES (2,'learn a verse', 'learn a verse of at least 400 words', 1);
INSERT INTO "PUBLIC".TASK VALUES (3,'write a poem', 'write the poem of at least 10 pages', 2);
INSERT INTO "PUBLIC".TASK VALUES (4,'write an essay', 'free topic on astronomy', 2);
INSERT INTO "PUBLIC".TASK VALUES (5,'learn the rules', 'rules of phonetics', 2);
INSERT INTO "PUBLIC".TASK VALUES (6,'Screaming', 'practice singing at least 10 minutes per day', 3);
INSERT INTO "PUBLIC".TASK VALUES (7,'Java', 'read about Strings', 4);
INSERT INTO "PUBLIC".TASK VALUES (8,'Hack', 'Hack the pentagon', 4);
INSERT INTO "PUBLIC".TASK VALUES (9,'Rest', 'Plan a break every hour for 10 minutes', 5);

-- Filling Table Subscribers
INSERT INTO "PUBLIC".SUBSCRIBERS VALUES (1, 1, 1);
INSERT INTO "PUBLIC".SUBSCRIBERS VALUES (2, 1, 2);
INSERT INTO "PUBLIC".SUBSCRIBERS VALUES (3, 1, 4);
INSERT INTO "PUBLIC".SUBSCRIBERS VALUES (4, 2, 1);
INSERT INTO "PUBLIC".SUBSCRIBERS VALUES (5, 2, 2);
INSERT INTO "PUBLIC".SUBSCRIBERS VALUES (6, 2, 3);
INSERT INTO "PUBLIC".SUBSCRIBERS VALUES (7, 2, 5);

-- Filling Table Evaluation
INSERT INTO "PUBLIC".EVALUATION VALUES (1, 3, 'Read only half', 1,1);
INSERT INTO "PUBLIC".EVALUATION VALUES (2, 4, 'good', 1,2);
INSERT INTO "PUBLIC".EVALUATION VALUES (3, 5, 'excelent!', 1,3);
INSERT INTO "PUBLIC".EVALUATION VALUES (4, 1, 'not complete', 1,4);
INSERT INTO "PUBLIC".EVALUATION VALUES (5, 2, 'not complete', 1,5);
INSERT INTO "PUBLIC".EVALUATION VALUES (6, 3, 'pure knowledge', 1,7);
INSERT INTO "PUBLIC".EVALUATION VALUES (7, 4, 'improve skills', 1,8);
INSERT INTO "PUBLIC".EVALUATION VALUES (8, 5, 'ok', 2,1);
INSERT INTO "PUBLIC".EVALUATION VALUES (9, 5, 'excelent!', 2,2);
INSERT INTO "PUBLIC".EVALUATION VALUES (10, 4, 'interesting theme', 2,3);
INSERT INTO "PUBLIC".EVALUATION VALUES (11, 3, '', 2,4);
INSERT INTO "PUBLIC".EVALUATION VALUES (12, 2, 'very bad', 2,5);
INSERT INTO "PUBLIC".EVALUATION VALUES (13, 1, 'AAAAA!!!', 2,6);
INSERT INTO "PUBLIC".EVALUATION VALUES (14, 5, 'zzzz', 2,9);



