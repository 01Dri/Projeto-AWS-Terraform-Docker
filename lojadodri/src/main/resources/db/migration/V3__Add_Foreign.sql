ALTER TABLE cliente_login
ADD CONSTRAINT fk_cliente_login_cliente
FOREIGN KEY (cliente_id) REFERENCES cliente(id);