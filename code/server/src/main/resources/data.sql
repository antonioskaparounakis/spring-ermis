-- Employees

-- Employee (Sam Taylor - Employee +Manager)
INSERT INTO employee (id, user_id, email, manager_id, created_by, created_date, last_modified_by, last_modified_date)
VALUES ('c0b84372-bc70-4ff6-a43a-e95dff55100c', 'auth0|65d7bb0eeccde4b89179ae37', 'sam.taylor@demo-company-1.com',
        'c0b84372-bc70-4ff6-a43a-e95dff55100c', 'c0b84372-bc70-4ff6-a43a-e95dff55100c', '2024-02-23',
        'c0b84372-bc70-4ff6-a43a-e95dff55100c', '2024-02-23');

-- Employee (John Doe - Administrator)
INSERT INTO employee (id, user_id, email, manager_id, created_by, created_date, last_modified_by, last_modified_date)
VALUES ('fd114001-8e08-44de-ac05-62fd71aeb336', 'auth0|65d7b6a4cbf0cc6d7163ed9d', 'john.doe@demo-company-1.com',
        'c0b84372-bc70-4ff6-a43a-e95dff55100c', 'fd114001-8e08-44de-ac05-62fd71aeb336', '2024-02-23',
        'fd114001-8e08-44de-ac05-62fd71aeb336', '2024-02-23');

-- Employee (Alex Kim - Employee)
INSERT INTO employee (id, user_id, email, manager_id, created_by, created_date, last_modified_by, last_modified_date)
VALUES ('0973e285-d326-4e02-b393-70d24173e2d2', 'auth0|65d7bb3318ca93f89007020f', 'AlexKim@demo-company-1.com',
        'c0b84372-bc70-4ff6-a43a-e95dff55100c', '0973e285-d326-4e02-b393-70d24173e2d2', '2024-02-23',
        '0973e285-d326-4e02-b393-70d24173e2d2', '2024-02-23');

-- Expense Types
INSERT INTO expense_type (id, name, description, created_by, created_date, last_modified_by, last_modified_date)
VALUES ('8f30aca6-04ff-49a8-8ee7-6cfbf8e5be40', 'Travel',
        'Expenses for business travel, including flights, lodging, and car rentals.',
        'fd114001-8e08-44de-ac05-62fd71aeb336', '2024-02-23', 'fd114001-8e08-44de-ac05-62fd71aeb336', '2024-02-23');

INSERT INTO expense_type (id, name, description, created_by, created_date, last_modified_by, last_modified_date)
VALUES ('ba85da35-4dff-4d0c-80a2-3fe0408fc0f0', 'Meals and Entertainment',
        'Expenses for meals and entertainment related to business activities.', 'fd114001-8e08-44de-ac05-62fd71aeb336',
        '2024-02-23', 'fd114001-8e08-44de-ac05-62fd71aeb336', '2024-02-23');

-- Expense Reports
INSERT INTO expense_report (id, employee_id, name, amount, status, created_by, created_date, last_modified_by, last_modified_date)
VALUES ('53ea631d-7643-4813-8c66-80dc2c63eed3', 'c0b84372-bc70-4ff6-a43a-e95dff55100c',
        'Quarterly Sales Team Travel Expense Report Q1 2024', '200', 'SUBMITTED', 'c0b84372-bc70-4ff6-a43a-e95dff55100c', '2024-02-23',
        'c0b84372-bc70-4ff6-a43a-e95dff55100c', '2024-02-23');

INSERT INTO expense_report (id, employee_id, name, amount, status, created_by, created_date, last_modified_by, last_modified_date)
VALUES ('30aca0b9-df2f-442c-afd4-455cca9c8375', 'c0b84372-bc70-4ff6-a43a-e95dff55100c',
        'Employee Team Building Meals Report April 2024', '80', 'APPROVED', 'c0b84372-bc70-4ff6-a43a-e95dff55100c', '2024-02-23',
        'c0b84372-bc70-4ff6-a43a-e95dff55100c', '2024-02-23');

INSERT INTO expense_report (id, employee_id, name, amount, status, created_by, created_date, last_modified_by, last_modified_date)
VALUES ('b6f89b9e-9c02-4a1a-85b3-9ce5c1900c9b', '0973e285-d326-4e02-b393-70d24173e2d2',
        'Annual Holiday Party Expenses Report 2024', '550', 'SUBMITTED', '0973e285-d326-4e02-b393-70d24173e2d2', '2024-02-23',
        '0973e285-d326-4e02-b393-70d24173e2d2', '2024-02-23');

INSERT INTO expense_report (id, employee_id, name, amount, status, created_by, created_date, last_modified_by, last_modified_date)
VALUES ('0cfe8d6f-2ef5-4040-9418-92253ffbdeb4', '0973e285-d326-4e02-b393-70d24173e2d2',
        'Annual Conference Accommodation Expenses 2024', '550', 'REJECTED', '0973e285-d326-4e02-b393-70d24173e2d2', '2024-02-23',
        '0973e285-d326-4e02-b393-70d24173e2d2', '2024-02-23');
