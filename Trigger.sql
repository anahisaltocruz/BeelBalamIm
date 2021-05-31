USE BEEL_BALAM;

--TRIGGER PARA MODIFICAR PUNTOS AL UPDATE RESERVA
DROP TRIGGER MODIFICAR_PTOS
CREATE TRIGGER MODIFICAR_PTOS
ON RESERVA
AFTER UPDATE 
AS BEGIN 
	IF ((SELECT NOMBRE_TR FROM deleted) <> ((SELECT NOMBRE_TR FROM inserted)))--Si se modifica el tramo de la reserva
		BEGIN
			DECLARE @ptosAnteriores INT;
			SET @ptosAnteriores = ((SELECT COSTO_TR FROM TRAMO WHERE NOMBRE_TR = (SELECT NOMBRE_TR FROM deleted))/700)*10;
			PRINT @ptosAnteriores;
			DECLARE @ptosNuevos INT;
			SET @ptosNuevos = ((SELECT COSTO_TR FROM TRAMO WHERE NOMBRE_TR = (SELECT NOMBRE_TR FROM inserted))/700)*10;
			PRINT @ptosNuevos;
			DECLARE @puntos INT;
			--DECLARE @usuario VARCHAR(25);
			--SET @usuario = (SELECT NOMBRE_U FROM inserted);
			--PRINT @usuario;
			--SET @puntos = (SELECT PTOS_ACUM_U FROM USUARIO WHERE NOMBRE_U = (@usuario)) - (@ptosAnteriores) + (@ptosNuevos);
			--PRINT @puntos;
			--UPDATE USUARIO SET PTOS_ACUM_U = @puntos WHERE NOMBRE_U = @usuario;
			--SELECT *FROM inserted;
			--SELECT *FROM deleted;
			--Actualiza el costo de la reserva
			UPDATE RESERVA SET COSTO_R = (SELECT COSTO_TR FROM TRAMO WHERE NOMBRE_TR = (SELECT NOMBRE_TR FROM inserted)) WHERE COD_R = (SELECT COD_R FROM inserted);
		END
END
