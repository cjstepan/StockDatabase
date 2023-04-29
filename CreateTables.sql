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
VALUES ('AAPL', 'Apple Inc.'), ('GOOG', 'Alphabet Inc.'), ('MSFT', 'Microsoft Corporation'), 
        ('AMZN', 'Amazon.com, Inc.'), ('FB', 'Meta Platforms, Inc.'), ('TSLA', 'Tesla, Inc.'), 
        ('JPM', 'JPMorgan Chase & Co.'), ('V', 'Visa Inc.'), ('BAC', 'Bank of America Corporation'),
        ('WMT', 'Walmart Inc.')
RETURNING company_id;

-- Insert data into Price_Over_Time table using the generated company_id values
INSERT INTO Price_Over_Time (company_id, date, price)
VALUES 
(1, '2023-04-29', 195.43), (2, '2023-04-29', 1982.98), (3, '2023-04-29', 650.71), (4, '2023-04-29', 140.22), (5, '2023-04-29', 378.90), 
(6, '2023-04-29', 942.30), (7, '2023-04-29', 109.81), (8, '2023-04-29', 790.05), (9, '2023-04-29', 246.54), (10, '2023-04-29', 534.12),
(1, '2023-04-28', 183.54), (2, '2023-04-28', 2225.30), (3, '2023-04-28', 598.32), (4, '2023-04-28', 132.47), (5, '2023-04-28', 417.60), 
(6, '2023-04-28', 821.89), (7, '2023-04-28', 105.76), (8, '2023-04-28', 752.34), (9, '2023-04-28', 212.90), (10, '2023-04-28', 499.05),
(1, '2023-04-27', 197.85), (2, '2023-04-27', 2109.42), (3, '2023-04-27', 712.60), (4, '2023-04-27', 142.80), (5, '2023-04-27', 385.79), 
(6, '2023-04-27', 911.37), (7, '2023-04-27', 98.60), (8, '2023-04-27', 829.48), (9, '2023-04-27', 255.16), (10, '2023-04-27', 575.11),
(1, '2023-04-26', 187.42), (2, '2023-04-26', 2346.81), (3, '2023-04-26', 667.15), (4, '2023-04-26', 136.29), (5, '2023-04-26', 403.20), 
(6, '2023-04-26', 889.22), (7, '2023-04-26', 99.38), (8, '2023-04-26', 713.60), (9, '2023-04-26', 227.09), (10, '2023-04-26', 542.96),
(1, '2023-04-25', 189.66), (2, '2023-04-25', 2413.10), (3, '2023-04-25', 657.98), (4, '2023-04-25', 139.73), (5, '2023-04-25', 391.55), 
(6, '2023-04-25', 877.72), (7, '2023-04-25', 98.92), (8, '2023-04-25', 674.83), (9, '2023-04-25', 226.31), (10, '2023-04-25', 529.34),
(1, '2023-04-24', 196.11), (2, '2023-04-24', 2336.45), (3, '2023-04-24', 712.49), (4, '2023-04-24', 142.36), (5, '2023-04-24', 378.42), 
(6, '2023-04-24', 864.06), (7, '2023-04-24', 100.63), (8, '2023-04-24', 720.56), (9, '2023-04-24', 246.63), (10, '2023-04-24', 552.19);


-- Insert data into Stock_Purchase table using the generated time_id values and account_id values
INSERT INTO Stock_Purchase (time_id, account_id, shares_purchased)
VALUES (1, 1, 100), (2, 2, 50)
