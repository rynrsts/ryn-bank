INSERT INTO customer
    (name, email, mobile_number, password, role, create_date)
VALUES
    ('Happy', 'happy@example.com','9876548337', '$2a$12$eBOXVumreMZc2A/T9Xcuj.QUV5kHzGakEuIyi/B9KE2GkIwll8VjS', 'admin', CURRENT_DATE);

INSERT INTO account
    (customer_id, account_number, account_type, branch_address, create_date)
VALUES
    (1, 1865764534, 'Savings', '123 Main Street, New York', CURRENT_DATE);

INSERT INTO account_transaction
    (transaction_id, account_number, customer_id, transaction_date, transaction_summary, transaction_type, transaction_amount, closing_balance, create_date)
VALUES -- transaction_id = UUID
    (1, 1865764534, 1, CURRENT_DATE, 'Coffee Shop', 'Withdrawal', 30, 34500, CURRENT_DATE),
    (2, 1865764534, 1, CURRENT_DATE, 'Uber', 'Withdrawal', 100, 34400, CURRENT_DATE),
    (3, 1865764534, 1, CURRENT_DATE, 'Self Deposit', 'Deposit', 500, 34900, CURRENT_DATE),
    (4, 1865764534, 1, CURRENT_DATE, 'Ebay', 'Withdrawal', 600, 34300, CURRENT_DATE),
    (5, 1865764534, 1, CURRENT_DATE, 'OnlineTransfer', 'Deposit', 700, 35000, CURRENT_DATE),
    (6, 1865764534, 1, CURRENT_DATE, 'Amazon.com', 'Withdrawal', 100, 34900, CURRENT_DATE);

INSERT INTO loan
    (customer_id, start_date, loan_type, total_loan, amount_paid, outstanding_amount, create_date)
VALUES
    (1, '2020-10-13', 'Home', 200000, 50000, 150000, '2020-10-13'),
    (1, '2020-06-06', 'Vehicle', 40000, 10000, 30000, '2020-06-06'),
    (1, '2018-02-14', 'Home', 50000, 10000, 40000, '2018-02-14'),
    (1, '2018-02-14', 'Personal', 10000, 3500, 6500, '2018-02-14');

INSERT INTO card
    (card_number, customer_id, card_type, total_limit, amount_used, available_amount, create_date)
VALUES
    ('4565XXXX4656', 1, 'Credit', 10000, 500, 9500, CURRENT_DATE),
    ('3455XXXX8673', 1, 'Credit', 7500, 600, 6900, CURRENT_DATE),
    ('2359XXXX9346', 1, 'Credit', 20000, 4000, 16000, CURRENT_DATE);

INSERT INTO notice
    (notice_summary, notice_details, notice_start_date, notice_end_date, create_date, update_date)
VALUES
    (
        'Home Loan Interest rates reduced',
        'Home loan interest rates are reduced as per the government guidelines. The updated rates will be effective immediately',
        CURRENT_DATE - 30 DAY,
        CURRENT_DATE + 30 DAY,
        CURRENT_DATE,
        null
    ),
    (
        'Net Banking Offers',
        'Customers who will opt for Internet banking while opening a saving account will get a $50 amazon voucher',
        CURRENT_DATE - 30 DAY,
        CURRENT_DATE + 30 DAY,
        CURRENT_DATE,
        null
    ),
        (
        'Mobile App Downtime',
        'The mobile application of the RynBank will be down from 2AM-5AM on 12/05/2020 due to maintenance activities',
        CURRENT_DATE - 30 DAY,
        CURRENT_DATE + 30 DAY,
        CURRENT_DATE,
        null
    ),
        (
        'E Auction notice',
        'There will be a e-auction on 12/08/2020 on the Bank website for all the stubborn arrears.Interested parties can participate in the e-auction',
        CURRENT_DATE - 30 DAY,
        CURRENT_DATE + 30 DAY,
        CURRENT_DATE,
        null
    ),
    (
        'Launch of Millennia Cards',
        'Millennia Credit Cards are launched for the premium customers of RynBank. With these cards, you will get 5% cashback for each purchase',
        CURRENT_DATE - 30 DAY,
        CURRENT_DATE + 30 DAY,
        CURRENT_DATE,
        null
    ),
    (
        'COVID-19 Insurance',
        'RynBank launched an insurance policy which will cover COVID-19 expenses. Please reach out to the branch for more details',
        CURRENT_DATE - 30 DAY,
        CURRENT_DATE + 30 DAY,
        CURRENT_DATE,
        null
    );

INSERT INTO authority
    (customer_id, name)
VALUES
    (1, 'ROLE_USER'),
    (1, 'ROLE_ADMIN');
