CREATE TABLE client(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(75) NOT NULL,
    lastname VARCHAR(75) NOT NULL,
    docnumber VARCHAR(11) UNIQUE NOT NULL
);

CREATE TABLE product(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(150) NOT NULL,
    description VARCHAR(150),
    code VARCHAR(50) UNIQUE NOT NULL,
    stock INTEGER,
    price DOUBLE
);

CREATE TABLE factura(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    id_client INT,
    fecha VARCHAR(255),
    total INTEGER,
    FOREIGN KEY (id_client) REFERENCES client (id)
);

CREATE TABLE detalle_factura(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    id_factura INT NOT NULL,
    id_producto INT NOT NULL,
    cantidad INTEGER,
    precio DOUBLE
    FOREIGN KEY (id_factura) REFERENCES factura(id)
    FOREIGN KEY (id_producto) REFERENCES product(id)
)