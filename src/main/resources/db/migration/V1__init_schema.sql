BEGIN;

-- ENUM for user roles
CREATE TYPE user_role AS ENUM (
    'CUSTOMER',
    'VENDOR'
);

-- ENUM for status
CREATE TYPE order_status AS ENUM (
    'CART',
    'PENDING',
    'COMPLETED',
    'CANCELLED'
);

-- ENUM for transaction type
CREATE TYPE transaction_type_enum AS ENUM ('DEPOSIT', 'PURCHASE', 'EARNING');

-- Create the 'users' table
CREATE TABLE users (
    id UUID PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    full_name VARCHAR(255),
    role user_role NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW()
);

-- Create the 'wallet' table
CREATE TABLE wallet(
    id UUID PRIMARY KEY,
    user_id UUID NOT NULL UNIQUE,
    balance NUMERIC(15,2) NOT NULL DEFAULT 0.00,
    version INT NOT NULL DEFAULT 0,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_wallet_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE RESTRICT
);

-- Create the 'inventory' table
CREATE TABLE inventory(
    id UUID PRIMARY KEY,
    vendor_id UUID NOT NULL,
    name VARCHAR(255) NOT NULL,
    price NUMERIC(10,2) NOT NULL,
    stock_quantity INT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_inventory_vendor FOREIGN KEY (vendor_id) REFERENCES users(id) ON DELETE CASCADE
);

-- Create the 'orders' table
CREATE TABLE orders(
    id UUID PRIMARY KEY,
    customer_id UUID NOT NULL,
    order_number VARCHAR(50) NOT NULL UNIQUE,
    total_amount NUMERIC(15,2),
    status order_status NOT NULL DEFAULT 'CART',
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_customer_order FOREIGN KEY (customer_id) REFERENCES users(id) ON DELETE CASCADE
);

-- Create the 'order_items' table
CREATE TABLE order_items(
    id UUID PRIMARY KEY,
    order_id UUID NOT NULL,
    product_id UUID NOT NULL,
    vendor_id UUID NOT NULL,
    quantity INT NOT NULL,
    price_at_purchase NUMERIC(10,2) NOT NULL,
    subtotal NUMERIC(15,2) NOT NULL,
    CONSTRAINT fk_orderitem_order FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE RESTRICT,
    CONSTRAINT fk_orderitem_product FOREIGN KEY (product_id) REFERENCES inventory(id) ON DELETE RESTRICT,
    CONSTRAINT fk_orderitem_vendor FOREIGN KEY (vendor_id) REFERENCES users(id) ON DELETE RESTRICT
);


CREATE TABLE wallet_transactions(
    id UUID PRIMARY KEY,
    wallet_id UUID NOT NULL,
    amount NUMERIC(15,2) NOT NULL,
    transaction_type transaction_type_enum NOT NULL,
    balance_before NUMERIC(15,2) NOT NULL,
    balance_after NUMERIC(15,2) NOT NULL,
    order_id UUID NULL,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_wallet_transaction_wallet FOREIGN KEY (wallet_id) REFERENCES wallet(id) ON DELETE RESTRICT,
    CONSTRAINT fk_wallet_transaction_order FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE SET NULL
);

COMMIT;
