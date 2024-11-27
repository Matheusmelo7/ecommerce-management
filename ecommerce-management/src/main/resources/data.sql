-- Inserção de Produtos Relacionados a uma Cafeteria

INSERT INTO PRODUCTS (ID_PRODUCT, NAME, DESCRIPTION, PRICE, STOCK_QUANTITY, CREATED_AT)
VALUES
    (NEXTVAL('products_seq'), 'Café Expresso', 'Café forte e intenso preparado com grãos premium', 800, 150, CURRENT_TIMESTAMP),
    (NEXTVAL('products_seq'), 'Cappuccino', 'Café com leite espumoso e um toque de chocolate', 1200, 200, CURRENT_TIMESTAMP),
    (NEXTVAL('products_seq'), 'Latte', 'Café com leite cremoso, perfeito para qualquer hora do dia', 1500, 180, CURRENT_TIMESTAMP),
    (NEXTVAL('products_seq'), 'Croissant', 'Massa folhada crocante recheada com chocolate ou creme', 1200, 100, CURRENT_TIMESTAMP),
    (NEXTVAL('products_seq'), 'Bolo de Cenoura', 'Bolo fofinho com cobertura de chocolate', 1800, 50, CURRENT_TIMESTAMP);
