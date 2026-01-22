-- ==============================================
-- DATOS DE PRUEBA PARA ECOMMERCE JPA
-- ==============================================

-- ==============================================
-- USUARIOS
-- ==============================================
INSERT INTO usuario (email, username, password, fecha_nacimiento) VALUES
('pablo@email.com', 'pablo123', 'password123', '1990-05-15 10:00:00'),
('ana@email.com', 'ana_gamer', 'password456', '1995-03-22 14:30:00'),
('carlos@email.com', 'carlos_dev', 'password789', '1988-12-10 09:00:00');

-- ==============================================
-- CATEGORÍAS
-- ==============================================
INSERT INTO categoria (nombre, descripcion) VALUES
('Consolas', 'Consolas de videojuegos'),
('Videojuegos', 'Juegos para consolas y PC'),
('Accesorios', 'Mandos, auriculares y otros'),
('Electrónica', 'Productos electrónicos diversos'),
('Merchandising', 'Camisetas, pósters y recuerdos');

-- ==============================================
-- PRODUCTOS
-- ==============================================
INSERT INTO producto (nombre, descripcion, imagen, sku, precio, cantidad, categoria_id) VALUES
('PS5 Slim', 'Consola PS5 edición slim 1TB', 'https://ejemplo.com/ps5slim.jpg', 'PS5-SLIM-001', 449.99, 10, 1),
('Xbox Series X', 'Consola Xbox Series X 1TB', 'https://ejemplo.com/xboxsx.jpg', 'XSX-001', 499.99, 8, 1),
('Nintendo Switch OLED', 'Consola Switch modelo OLED', 'https://ejemplo.com/switcholed.jpg', 'NSW-OLED-001', 349.99, 15, 1),
('God of War Ragnarök', 'Juego para PS5', 'https://ejemplo.com/gowr.jpg', 'GOW-RAGNAROK', 69.99, 50, 2),
('The Legend of Zelda: TOTK', 'Juego para Nintendo Switch', 'https://ejemplo.com/totk.jpg', 'ZELDA-TOTK', 59.99, 30, 2),
('Mando DualSense PS5', 'Mando oficial PS5', 'https://ejemplo.com/dualsense.jpg', 'DSENSE-001', 59.99, 25, 3),
('Mando Xbox Series', 'Mando oficial Xbox', 'https://ejemplo.com/mandoxbox.jpg', 'MANDO-XBOX', 59.99, 20, 3),
('Auriculares PS5 Pulse', 'Auriculares inalámbricos PS5', 'https://ejemplo.com/pulse3d.jpg', 'PULSE-3D', 89.99, 12, 3),
('Tarjeta PSN 50€', 'Tarjeta regalo PSN 50 euros', 'https://ejemplo.com/psn50.jpg', 'PSN-50', 50.00, 100, 4),
('Camiseta PS5', 'Camiseta oficial PS5', 'https://ejemplo.com/camisetaps5.jpg', 'CAMISA-PS5', 29.99, 40, 5);

-- ==============================================

