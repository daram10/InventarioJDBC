-- ============================================================
--  Base de datos: Inventario Supermercado
--  Usar este script en MySQL Workbench o MySQL CLI
--  Autora: Danna Ramirez
-- ============================================================

-- 1. Crear la base de datos
CREATE DATABASE IF NOT EXISTS inventario_supermercado
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_spanish_ci;

-- 2. Seleccionarla
USE inventario_supermercado;

-- 3. Crear la tabla de productos
CREATE TABLE IF NOT EXISTS productos (
    id            INT          NOT NULL AUTO_INCREMENT,
    nombre        VARCHAR(100) NOT NULL,
    categoria     VARCHAR(50)  NOT NULL,
    precio        DECIMAL(10,2) NOT NULL,
    cantidad      INT          NOT NULL DEFAULT 0,
    PRIMARY KEY (id)
);

-- 4. Insertar datos de ejemplo
INSERT INTO productos (nombre, categoria, precio, cantidad) VALUES
    ('Arroz 1kg',       'Granos',    2500.00, 50),
    ('Aceite 1L',       'Aceites',   8900.00, 30),
    ('Leche 1L',        'Lacteos',   3200.00, 40),
    ('Azucar 1kg',      'Endulzantes',1800.00, 60),
    ('Papel Higienico', 'Aseo',      4500.00, 25);
