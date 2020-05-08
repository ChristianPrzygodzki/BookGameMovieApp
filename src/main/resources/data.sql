INSERT INTO BOOK(ID, TITLE, RATE, DESCRIPTION, AUTHOR)
VALUES (1, 'Potop', 9.0, 'Historia Andrzeja Kmicica na tle potopu szwedzkiego w XVII w.', 'H. Sienkiewicz');

INSERT INTO BOOK(ID, TITLE, RATE, DESCRIPTION, AUTHOR)
VALUES (2, 'Zbrodnia i kara', 8.0, 'O morderstwie i drodze nawrócenia.', 'F. Dostojewski');

INSERT INTO BOOK(ID, TITLE, RATE, DESCRIPTION, AUTHOR)
VALUES (3, '20000 mil podmorskiej żeglugi', 8.0, 'Przygody profesora Pierre`a Arronaxa.', 'J. Verne');

INSERT INTO BOOK(ID, TITLE, RATE, DESCRIPTION, AUTHOR)
VALUES (4, 'Harry Potter i Kamień Filozoficzny', 7.0, 'O czarodziejach', 'J. K. Rowling');

INSERT INTO BOOK(ID, TITLE, RATE, DESCRIPTION, AUTHOR)
VALUES (5, 'Solaris', 9.0, 'Tajemnicza planeta zdaje się być żywym organizmem', 'S. Lem');

INSERT INTO BOOK(ID, TITLE, RATE, DESCRIPTION, AUTHOR)
VALUES (6, 'Boska Komedia', 10.0, 'Podróż po piekle, czyśćcu i raju', 'D. Alighieri');

INSERT INTO BOOK(ID, TITLE, RATE, DESCRIPTION, AUTHOR)
VALUES (7, 'Maska', 9.0, 'Tajemnicza i mroczna opowieść w wymyślonym świecie, będącym mieszanką feudalizmu i nowoczesnej technologii. ', 'S. Lem');

INSERT INTO Game(ID, TITLE, RATE, DESCRIPTION, FORMAT)
VALUES (1, 'CS:GO', 10.0, 'Terro vs CT', 'STEAM');

INSERT INTO Game(ID, TITLE, RATE, DESCRIPTION, FORMAT)
VALUES (2, 'Warcraft III', 10.0, 'RTS, where You can play as Human, Orc, Night Elf or Undead.', 'OTHER_LICENCE');

INSERT INTO Game(ID, TITLE, RATE, DESCRIPTION, FORMAT)
VALUES (3, 'Diablo II', 8.0, 'Choose Your hero and fight the evil.', 'CD');

INSERT INTO Game(ID, TITLE, RATE, DESCRIPTION, FORMAT)
VALUES (4, 'Kozacy: Powrót na wojnę', 6.0, 'Play as one of 20 nations, fight in battles with thousands of soldiers.', 'CD');

INSERT INTO MOVIE(ID, TITLE, RATE, DESCRIPTION) VALUES (1, 'Ogniem i mieczem', 9.0, 'Adaptacja powieści Henryka Sienkiewicza.');

INSERT INTO MOVIE(ID, TITLE, RATE, DESCRIPTION) VALUES (2, 'Leon Zawodowiec', 10.0, 'Zabójca i dziewczynka.');

INSERT INTO MOVIE(ID, TITLE, RATE, DESCRIPTION) VALUES (3, 'Hero', 10.0, 'O zamachu na króla.');

INSERT INTO MOVIE(ID, TITLE, RATE, DESCRIPTION) VALUES (4, 'Prestiż', 10.0, 'Sztuczki magiczki.');

INSERT INTO MOVIE(ID, TITLE, RATE, DESCRIPTION) VALUES (5, 'Pasja', 10.0, 'Ostatnie chwile życia Jezusa.');

INSERT INTO ACTOR(ID, NAME, SURNAME) VALUES (1, 'Michał', 'Żebrowski');

INSERT INTO ACTOR(ID, NAME, SURNAME) VALUES (2, 'Krzysztof', 'Kowalewski');

INSERT INTO ACTOR(ID, NAME, SURNAME) VALUES (3, 'Izabella', 'Scorupco');

INSERT INTO ACTOR(ID, NAME, SURNAME) VALUES (4, 'Zbigniew', 'Zamachowski');

INSERT INTO ACTOR(ID, NAME, SURNAME) VALUES (5, 'Jean', 'Reno');

INSERT INTO ACTOR(ID, NAME, SURNAME) VALUES (6, 'Natalie', 'Portman');

INSERT INTO ACTOR(ID, NAME, SURNAME) VALUES (7, 'Gary', 'Oldman');

INSERT INTO ACTOR(ID, NAME, SURNAME) VALUES (8, 'Jet', 'Li');

INSERT INTO ACTOR(ID, NAME, SURNAME) VALUES (9, 'Christian', 'Bale');

INSERT INTO ACTOR(ID, NAME, SURNAME) VALUES (10, 'Hugh', 'Jackman');

INSERT INTO ACTOR(ID, NAME, SURNAME) VALUES (11, 'Scarlett', 'Johansson');

INSERT INTO ACTOR(ID, NAME, SURNAME) VALUES (12, 'Michael', 'Caine');

INSERT INTO ACTOR(ID, NAME, SURNAME) VALUES (13, 'Jim', 'Caviezel');

INSERT INTO ACTOR(ID, NAME, SURNAME) VALUES (14, 'Monica', 'Bellucci');

INSERT INTO MOVIE_TO_ACTOR(MOVIE_ID, ACTOR_ID) VALUES (1, 1);

INSERT INTO MOVIE_TO_ACTOR(MOVIE_ID, ACTOR_ID) VALUES (1, 2);

INSERT INTO MOVIE_TO_ACTOR(MOVIE_ID, ACTOR_ID) VALUES (1, 3);

INSERT INTO MOVIE_TO_ACTOR(MOVIE_ID, ACTOR_ID) VALUES (1, 4);

INSERT INTO MOVIE_TO_ACTOR(MOVIE_ID, ACTOR_ID) VALUES (2, 5);

INSERT INTO MOVIE_TO_ACTOR(MOVIE_ID, ACTOR_ID) VALUES (2, 6);

INSERT INTO MOVIE_TO_ACTOR(MOVIE_ID, ACTOR_ID) VALUES (2, 7);

INSERT INTO MOVIE_TO_ACTOR(MOVIE_ID, ACTOR_ID) VALUES (3, 8);

INSERT INTO MOVIE_TO_ACTOR(MOVIE_ID, ACTOR_ID) VALUES (4, 9);

INSERT INTO MOVIE_TO_ACTOR(MOVIE_ID, ACTOR_ID) VALUES (4, 10);

INSERT INTO MOVIE_TO_ACTOR(MOVIE_ID, ACTOR_ID) VALUES (4, 11);

INSERT INTO MOVIE_TO_ACTOR(MOVIE_ID, ACTOR_ID) VALUES (4, 12);

INSERT INTO MOVIE_TO_ACTOR(MOVIE_ID, ACTOR_ID) VALUES (5, 13);

INSERT INTO MOVIE_TO_ACTOR(MOVIE_ID, ACTOR_ID) VALUES (5, 14);