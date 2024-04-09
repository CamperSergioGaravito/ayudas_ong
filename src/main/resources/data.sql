
CREATE DATABASE IF NOT EXISTS ONG;

INSERT into roles ( nombre, descripcion) values 
(1, "permiso en todo"),
(2, "permisos gestion: socios, voluntarios, envíos"),
(3, "consultar reportes");

INSERT INTO directores ( cedula, p_nombre, s_nombre, p_apellido, s_apellido, email, pass_word, rol_id)
VALUES (123456789, "admin", NULL, "admin", NULL, "admin@mail.com", "admin", 1);

INSERT INTO ciudades (nombre)
VALUES
    ('Bogotá'),
    ('Medellín'),
    ('Cali'),
    ('Barranquilla'),
    ('Cartagena'),
    ('Bucaramanga'),
    ('Pereira'),
    ('Santa Marta'),
    ('Manizales'),
    ('Ibagué');

INSERT INTO sedes (direccion, nombre, ciudad_id, director_id)
VALUES
('Calle 1 Carrera 1', 'sede A', 1, NULL),
('Calle 2 Carrera 2', 'sede B', 2, NULL),
('Calle 3 Carrera 3', 'sede C', 3, NULL),
('Calle 4 Carrera 4', 'sede D', 4, NULL),
('Calle 5 Carrera 5', 'sede E', 5, NULL),
('Calle 6 Carrera 6', 'sede F', 6, NULL),
('Calle 7 Carrera 7', 'sede G', 7, NULL),
('Calle 8 Carrera 8', 'sede H', 8, NULL),
('Calle 9 Carrera 9', 'sede I', 9, NULL),
('Calle 0 Carrera 0', 'sede J', 10, NULL);

INSERT INTO refugios (direccion, nombre, ciudad_id)
VALUES
('Calle 1 Carrera 1', 'sede A', 1),
('Calle 2 Carrera 2', 'sede B', 2),
('Calle 3 Carrera 3', 'sede C', 3),
('Calle 4 Carrera 4', 'sede D', 4),
('Calle 5 Carrera 5', 'sede E', 5),
('Calle 6 Carrera 6', 'sede F', 6),
('Calle 7 Carrera 7', 'sede G', 7),
('Calle 8 Carrera 8', 'sede H', 8),
('Calle 9 Carrera 9', 'sede I', 9),
('Calle 0 Carrera 0', 'sede J', 10);

INSERT INTO profesiones (nombre) 
VALUES 
('Médico'),
('Enfermero/a'),
('Fisioterapeuta'),
('Farmacéutico/a'),
('Nutricionista'),
('Psicólogo/a'),
('Técnico/a de laboratorio'),
('Terapeuta ocupacional'),
('Dentista'),
('Optometrista');

INSERT INTO articulos (nombre, tipo)
VALUES 
('Arroz', 1),
('Leche', 1),
('Pan', 1),
('Manzanas', 1),
('Pollo', 1),
('Pescado', 1),
('Huevos', 1),
('Pasta', 1),
('Cereal', 1),
('Yogur', 1),
('Paracetamol', 2),
('Ibuprofeno', 2),
('Aspirina', 2),
('Vitaminas', 2),
('Antibiótico', 2),
('Jarabe para la tos', 2),
('Antiinflamatorio', 2),
('Analgésico', 2),
('Gotas para los ojos', 2),
('Pastillas para dormir', 2);

