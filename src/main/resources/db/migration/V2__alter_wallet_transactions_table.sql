BEGIN;
ALTER TABLE wallet_transactions
ADD COLUMN balance_before NUMERIC(15,2) NOT NULL,
ADD COLUMN balance_after NUMERIC(15,2) NOT NULL,
ADD COLUMN order_id UUID NULL,
ADD COLUMN created_at TIMESTAMP;


ALTER TABLE wallet_transactions
RENAME COLUMN transaction_type TO type;


ALTER TABLE wallet_transactions
ADD CONSTRAINT fk_order
FOREIGN KEY (order_id) REFERENCES orders(id)
ON DELETE SET NULL;

COMMIT;