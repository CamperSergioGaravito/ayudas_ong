
CREATE DATABASE IF NOT EXISTS ONG;

INSERT into roles ( nombre, descripcion) values 
(1, "permiso en todo"),
(2, "permisos gestion: socios, voluntarios, envíos"),
(3, "consultar reportes");

INSERT INTO directores ( cedula, p_nombre, s_nombre, p_apellido, s_apellido, email, pass_word, rol_id)
VALUES (123456789, "admin", NULL, "admin", NULL, "admin@mail.com", "admin", 1);