-- Customers
INSERT INTO customer (name, customer_number, email, phone_number) VALUES ('Denis Normand', '1', 'denisnormand@gmail.com', '0472255896');

-- Categories
INSERT INTO category (category) VALUES ('Action'), ('Comedy'), ('Drama'), ('SciFi'), ('Horror');

-- Movies (Single Table Insertion)
INSERT INTO movie (id, title, category_id, release_date, language, movie_type, number_discs, format) VALUES
(1, 'Gladiator', 1, '2000-05-05 00:00:00', 2, 'DVD', 2, NULL),
(2, 'Pulp Fiction', 3, '1994-10-14 00:00:00', 2, 'DVD', 1, NULL),
(3, 'Die Hard', 1, '1988-07-15 00:00:00', 2, 'VHS', NULL, 1),
(4, 'Terminator 2: Judgment Day', 1, '1991-07-03 00:00:00', 2, 'VHS', NULL, 1),
(5, 'Inception', 4, '2010-07-16 00:00:00', 1, 'DVD', 1, NULL),
(6, 'The Matrix', 4, '1999-03-31 00:00:00', 1, 'DVD', 2, NULL),
(7, 'The Godfather', 3, '1972-03-24 00:00:00', 1, 'VHS', NULL, 0),
(8, 'The Dark Knight', 1, '2008-07-18 00:00:00', 1, 'DVD', 2, NULL),
(9, 'Schindler''s List', 3, '1993-12-15 00:00:00', 1, 'VHS', NULL, 0),
(10, 'Fight Club', 3, '1999-10-15 00:00:00', 1, 'DVD', 1, NULL),
(11, 'The Shining', 5, '1980-05-23 00:00:00', 1, 'VHS', NULL, 0),
(12, 'Star Wars: A New Hope', 4, '1977-05-25 00:00:00', 1, 'VHS', NULL, 0),
(13, 'Alien', 4, '1979-05-25 00:00:00', 1, 'VHS', NULL, 0),
(14, 'Blade Runner', 4, '1982-06-25 00:00:00', 1, 'VHS', NULL, 0),
(15, 'Back to the Future', 4, '1985-07-03 00:00:00', 1, 'VHS', NULL, 0),
(16, 'Back to the Future', 4, '1985-07-03 00:00:00', 1, 'VHS', NULL, 0),
(17, 'Back to the Future', 4, '1985-07-03 00:00:00', 1, 'VHS', NULL, 0);
-- Rentals
INSERT INTO rental (rental_date, expected_return_date, price, customer_id)
VALUES ('2024-07-16 10:00:00', '2024-08-16 10:00:00', 5.99, 1);

INSERT INTO rental_movie (rental_id, movie_id) VALUES
    (1, 1),
    (1, 2),
    (1, 3),
    (1, 4);


INSERT INTO customer (name, customer_number, email, phone_number) VALUES
    ('Alice Johnson', '2', 'alice.johnson@example.com', '1234567890'),
    ('Bob Smith', '3', 'bob.smith@example.com', '9876543210');

INSERT INTO rental (rental_date, expected_return_date, price, customer_id)
VALUES
    ('2024-07-18 12:00:00', '2024-08-18 12:00:00', 7.99, 1),
    ('2024-07-17 14:00:00', '2024-08-17 14:00:00', 4.99, 2);

INSERT INTO rental_movie (rental_id, movie_id) VALUES
    (2, 5),
    (2, 6),
    (2, 7),
    (2, 8);
INSERT INTO rental (rental_date, expected_return_date, price, customer_id)
VALUES ('2024-07-10 10:00:00', '2024-07-17 10:00:00', 9.99, 1);

INSERT INTO rental_movie (rental_id, movie_id) VALUES
    (4, 9),
    (4, 10);