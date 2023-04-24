CREATE TABLE IF NOT EXISTS Person (
    person_id SERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS Account_Type (
    account_type_id SERIAL PRIMARY KEY,
    description VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS Account_Ownership (
    account_id SERIAL PRIMARY KEY,
    person_id INT NOT NULL,
    account_type_id INT NOT NULL,
    FOREIGN KEY (person_id) REFERENCES Person(person_id),
    FOREIGN KEY (account_type_id) REFERENCES Account_Type(account_type_id)
);

CREATE TABLE IF NOT EXISTS Company_Information (
    company_id SERIAL PRIMARY KEY,
    ticker VARCHAR(255) NOT NULL UNIQUE,
    description VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS Price_Over_Time (
    time_id SERIAL PRIMARY KEY,
    company_id INT NOT NULL,
    date DATE NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (company_id) REFERENCES Company_Information(company_id)
);

CREATE TABLE IF NOT EXISTS Stock_Purchase (
    time_id INT NOT NULL,
    account_id INT NOT NULL,
    shares_purchased INT NOT NULL,
    FOREIGN KEY (time_id) REFERENCES Price_Over_Time(time_id),
    FOREIGN KEY (account_id) REFERENCES Account_Ownership(account_id),
    PRIMARY KEY (time_id, account_id)
);

-- Insert data into Person table and retrieve generated person_id values
INSERT INTO Person (first_name, last_name)
VALUES ('John', 'Doe'), ('Jane', 'Doe')
RETURNING person_id;

-- Insert data into Account_Type table and retrieve generated account_type_id values
INSERT INTO Account_Type (description)
VALUES ('Roth IRA'), ('529 Plan'), ('Individual 401(k)')
RETURNING account_type_id;

-- Insert data into Account_Ownership table using the generated person_id and account_type_id values
INSERT INTO Account_Ownership (person_id, account_type_id)
VALUES (1, 1), (2, 2);

-- Insert data into Company_Information table and retrieve generated company_id values
INSERT INTO Company_Information (ticker, description)
VALUES ('AAPL', 'Apple Inc.'), ('GOOG', 'Alphabet Inc.')
RETURNING company_id;

-- Insert data into Price_Over_Time table using the generated company_id values
INSERT INTO Price_Over_Time (company_id, date, price)
VALUES (1, '2022-01-01', 180.43), (2, '2022-01-01', 2891.98);

-- Insert data into Stock_Purchase table using the generated time_id values and account_id values
INSERT INTO Stock_Purchase (time_id, account_id, shares_purchased)
VALUES (1, 1, 100), (2, 2, 50)
