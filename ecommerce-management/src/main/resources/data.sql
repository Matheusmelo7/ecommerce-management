-- Inserção de Produtos Relacionados a uma Cafeteria

INSERT INTO PRODUCTS (ID_PRODUCT, NAME, DESCRIPTION, PRICE, STOCK_QUANTITY, CREATED_AT)
VALUES
    (NEXTVAL('products_seq'), 'Café Expresso', 'Café forte e intenso preparado com grãos premium', 8.00, 150, CURRENT_TIMESTAMP),
    (NEXTVAL('products_seq'), 'Cappuccino', 'Café com leite espumoso e um toque de chocolate', 12.00, 200, CURRENT_TIMESTAMP),
    (NEXTVAL('products_seq'), 'Latte', 'Café com leite cremoso, perfeito para qualquer hora do dia', 15.00, 180, CURRENT_TIMESTAMP),
    (NEXTVAL('products_seq'), 'Croissant', 'Massa folhada crocante recheada com chocolate ou creme', 12.00, 100, CURRENT_TIMESTAMP),
    (NEXTVAL('products_seq'), 'Bolo de Cenoura', 'Bolo fofinho com cobertura de chocolate', 18.00, 50, CURRENT_TIMESTAMP);
