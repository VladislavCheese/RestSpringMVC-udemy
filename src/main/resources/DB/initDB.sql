drop table if exists people;
CREATE TABLE people (
                           people_id serial NOT NULL,
                           name varchar(15),
                           surname varchar(25),
                           department varchar(20),
                           salary int,
                           PRIMARY KEY (people_id)
) ;

INSERT INTO people(name, surname, department, salary)
VALUES
('Zaur', 'Tregulov', 'IT', 500),
('Oleg', 'Ivanov', 'Sales', 700),
('Nina', 'Sidorova', 'HR', 850);
