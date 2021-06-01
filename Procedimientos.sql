USE BEEL_BALAM;

CREATE PROCEDURE CREAR_USUARIO(
--datos usuario
@u_nombre VARCHAR(25),
@u_contraseña VARCHAR (20),
@u_correo VARCHAR (35),
@u_numCelular VARCHAR (14),
@u_ptos INT,
--datos tarjeta
@t_cvc INT,
@t_primerNombre VARCHAR(15),
@t_segundoNombre VARCHAR(15),
@t_primerApellido VARCHAR(15),
@t_segundoApellido VARCHAR(15),
@t_fechaVigencia INT,
@t_numero VARCHAR (17)
)
AS
BEGIN
	IF EXISTS (SELECT NOMBRE_U FROM USUARIO WHERE NOMBRE_U = @u_nombre)
		BEGIN 
				SELECT 'ESA USUARIO YA ESTÁ REGISTRADO';
		END 
	ELSE
	BEGIN 
		IF EXISTS (SELECT NUM_TARJETA FROM TARJETA WHERE NUM_TARJETA = @t_numero)
			BEGIN 
				SELECT 'ESA TARJETA YA ESTÁ REGISTRADA';
			END 
		ELSE
			BEGIN 
				INSERT INTO TARJETA
				VALUES (@t_cvc,@t_primerNombre,@t_segundoNombre,@t_primerApellido,@t_segundoApellido,@t_fechaVigencia,@t_numero);
			END
		INSERT INTO USUARIO
		VALUES (@u_nombre,@u_contraseña,@u_correo,@u_numCelular,@u_ptos,@t_numero); 
	END 
END

--pruebas ejecucion 
EXECUTE CREAR_USUARIO 'juanito','12decd23','juan@dsnd','99823743',0,123,'juan',NULL,'perez',NULL,1290,'0983648';
EXECUTE CREAR_USUARIO 'luisito','12decd23','juan@dsnd','99823743',0,123,'juan',NULL,'perez',NULL,1290,'1234567890123456';
EXECUTE CREAR_USUARIO 'luisito','12decd23','juan@dsnd','99823743',0,123,'juan',NULL,'perez',NULL,1290,'1234567890123456';

SELECT *FROM ESTACIONES

BEGIN --PROC ELIMINAR USUARIO 
DROP PROCEDURE ELIMINAR_USUARIO;
CREATE PROCEDURE ELIMINAR_USUARIO(
	--usuario
	@ub_nombre VARCHAR(25),
	--tarjeta
	@tb_numero VARCHAR (17)
)
AS
BEGIN 
	DECLARE @auxIdCliente INT;
	SELECT @auxIdCliente = ID_CLIENTE FROM RESERVA WHERE NOMBRE_U=@ub_nombre;

	DELETE FROM RESERVA WHERE NOMBRE_U=@ub_nombre;
	SELECT 'SE HA ELIMINADO CORRECTAMENTE LA RESERVA';

	DELETE FROM CLIENTE WHERE ID_CLIENTE=@auxIdCliente;
	SELECT 'SE HA ELIMINADO CORRECTAMENTE AL CLIENTE';

	DELETE FROM USUARIO WHERE NOMBRE_U=@ub_nombre;
	SELECT 'SE HA ELIMINADO CORRECTAMENTE EL USUARIO';

	DECLARE @numVecesTarj INT;
	SELECT @numVecesTarj = COUNT(NUM_TARJETA) FROM TARJETA WHERE NUM_TARJETA=@tb_numero;
	IF @numVecesTarj>=2
		BEGIN
			SELECT 'LA TARJETA LA POSEEN DOS USUARIOS';
		END
	ELSE 
		BEGIN
			DELETE FROM TARJETA WHERE NUM_TARJETA=@tb_numero;
			SELECT 'SE HA ELIMINADO CORRECTAMENTE LA TARJETA';
		END

--PRUEBAS 
SELECT * FROM USUARIO;
SELECT * FROM TARJETA;
SELECT * FROM CLIENTE;
SELECT * FROM RESERVA;
EXECUTE ELIMINAR_USUARIO 'adalcv','6734567890123456';
EXECUTE ELIMINAR_USUARIO 'anahisc','1134567890123456';
END
END 

--PROC. CANCELAR RESERVA
DROP PROCEDURE CANCELAR_RESERVA;
CREATE PROCEDURE CANCELAR_RESERVA(
	@cod_reserva INT	
)
AS
BEGIN
	DECLARE @auxIdCliente INT;
	SELECT @auxIdCliente = ID_CLIENTE FROM RESERVA WHERE COD_R=@cod_reserva;

	DECLARE @auxNombreU VARCHAR(25);
	SELECT @auxNombreU = NOMBRE_U FROM RESERVA WHERE COD_R=@cod_reserva;

	DECLARE @auxPtosAcum INT;
	SELECT @auxPtosAcum = PTOS_ACUM_U FROM USUARIO WHERE NOMBRE_U=@auxNombreU;

	DELETE FROM RESERVA WHERE COD_R=@cod_reserva;
	SELECT 'SE HA BORRADO CORRECTAMENTE LA RESERVA';
	UPDATE USUARIO SET PTOS_ACUM_U=(PTOS_ACUM_U-@auxPtosAcum) WHERE NOMBRE_U=@auxNombreU;
	SELECT 'SE HAN MODIFICADO CORRECTAMENTE LOS PUNTOS ACUMULADOS';
	DELETE FROM CLIENTE WHERE ID_CLIENTE=@auxIdCliente; 
	SELECT 'SE HA BORRADO CORRECTAMENTE AL CLIENTE';	
END 

--HACIENDO PRUEBAS DE EJECUCIÓN :D 
SELECT * FROM RESERVA;
SELECT * FROM USUARIO;
UPDATE USUARIO SET PTOS_ACUM_U=100 WHERE NOMBRE_U='itzeeelcava';
SELECT * FROM CLIENTE;

EXECUTE CANCELAR_RESERVA '9876';
END 

BEGIN --PROC. EDITAR USUARIO
CREATE PROCEDURE EDITAR_USUARIO(
--falta validar el newNombre, newContraseña,newCorreo,newCel,newNumeroTarjeta
@u_nombre VARCHAR (25),
--nuevos datos del usuario
@u_newNombre VARCHAR (25),
@u_newContraseña VARCHAR (20),
@u_newCorreo VARCHAR (35),
@u_newCel VARCHAR (14),
--datos de la nueva tarjeta
@u_newNumeroTarjeta VARCHAR (17),
@t_cvc INT,
@t_primerNombre VARCHAR (15),
@t_segundoNombre VARCHAR (15),
@t_primerApellido VARCHAR (15),
@t_segundoApellido VARCHAR (15),
@t_fechaVigencia INT
)
AS 
BEGIN 
	IF EXISTS (SELECT NOMBRE_U FROM USUARIO WHERE NOMBRE_U = @u_nombre)
		BEGIN
			IF (@u_newContraseña IS NOT NULL)
				BEGIN
					UPDATE USUARIO SET CONTRASENIA_U = @u_newContraseña WHERE NOMBRE_U = @u_nombre;	
				END
			IF (@u_newCorreo IS NOT NULL)
				BEGIN
					UPDATE USUARIO SET CORREO_U = @u_newCorreo WHERE NOMBRE_U = @u_nombre;	
				END
			IF (@u_newCel IS NOT NULL)
				BEGIN
					UPDATE USUARIO SET NUM_CEL_U = @u_newCel WHERE NOMBRE_U = @u_nombre;	
				END
			IF (@u_newNumeroTarjeta IS NOT NULL)
				BEGIN
					IF EXISTS (SELECT NUM_TARJETA FROM TARJETA WHERE NUM_TARJETA = @u_newNumeroTarjeta)--ya existe la tarjeta
						BEGIN
							UPDATE USUARIO SET NUM_TARJETA_U = @u_newNumeroTarjeta WHERE NOMBRE_U = @u_nombre;
						END
					ELSE 
						BEGIN--no existe la tarjeta
							--se registra la tarjeta
							INSERT INTO TARJETA
							VALUES (@t_cvc,@t_primerNombre,@t_segundoNombre,@t_primerApellido,@t_segundoApellido,@t_fechaVigencia,@u_newNumeroTarjeta);
							--actualiza
							UPDATE USUARIO SET NUM_TARJETA_U = @u_newNumeroTarjeta WHERE NOMBRE_U = @u_nombre; 
						END
				END
			IF (@u_newNombre IS NOT NULL)
				BEGIN
					IF EXISTS (SELECT NOMBRE_U FROM USUARIO WHERE NOMBRE_U = @u_newNombre)
						BEGIN SELECT 'ERROR, ESE USUARIO YA EXISTE'; END
					ELSE 
						BEGIN 
							UPDATE USUARIO SET NOMBRE_U = @u_newNombre WHERE NOMBRE_U = @u_nombre;
						END
				END
		END
	ELSE
		BEGIN
			SELECT 'ERROR, ESE USUARIO NO EXISTE'; --esto no va a pasar ya que se va a eliminar desde el perfil
		END
END

--PRUEBA
EXECUTE EDITAR_USUARIO 'pollito',NULL,'CNSDKNC',NULL,'9987889234','1134567890123456',NULL,NULL,NULL,NULL,NULL,NULL
END

BEGIN --PROC COMPRA BOLETOS
DROP PROCEDURE COMPRA_BOLETOS
CREATE PROCEDURE COMPRA_BOLETOS(
@c_primerNombre VARCHAR (15),--
@c_segundoNombre VARCHAR (15),--
@c_primerApellido VARCHAR (15),--
@c_segundoApellido VARCHAR (15),--
@c_edad INT,--
@c_nacionalidad VARCHAR (25),--
@matTren VARCHAR (25),--
@fechaReserva DATETIME,
@u_nombre VARCHAR (25),--
@tr_nombre VARCHAR (25)--
)
AS
BEGIN
	IF((SELECT CAPACIDAD FROM TREN WHERE MAT_TREN = @matTren) > 0 )
		BEGIN
			DECLARE @nClientes INT;
			SET @nClientes = (SELECT COUNT(*) FROM CLIENTE)+1;
			--crea un cliente
			INSERT INTO CLIENTE
			VALUES(@nClientes,@c_primerNombre,@c_segundoNombre,@c_primerApellido,@c_segundoApellido,@c_edad,@c_nacionalidad);

			--genera una reserva
			DECLARE @nReservas INT;
			SET @nReservas = (SELECT COUNT(COD_R) FROM RESERVA)+1;
			INSERT INTO RESERVA
			VALUES (@nReservas,@fechaReserva,@u_nombre,@tr_nombre,@nClientes,0.0);

			--actualiza la capacidad del tren
			UPDATE TREN SET CAPACIDAD = CAPACIDAD - 1 WHERE MAT_TREN = @matTren;

			--calcula el costo 
			DECLARE @costo INT;
			DECLARE @puntos INT;
			DECLARE @puntosAbonados INT;
			SET @costo = (SELECT COSTO_TR FROM TRAMO WHERE NOMBRE_TR = @tr_nombre);
			SET @puntos = (SELECT PTOS_ACUM_U FROM USUARIO WHERE NOMBRE_U = @u_nombre);

			IF (@puntos >= 100)
			BEGIN
				SET @puntosAbonados = 10*(@costo % 700); --puntos que se le van a abonar
				SET @costo = @costo - 300; --descuento
				SET @puntos = (@puntos-100) + @puntosAbonados; --disminuyen los puntos
		
				UPDATE USUARIO SET PTOS_ACUM_U = @puntos WHERE NOMBRE_U = @u_nombre;
			END
		END
	ELSE 
		BEGIN 
			SELECT 'NO HAY ASIENTOS DISPONIBLES'
		END
END

END 

BEGIN --PROC FILTRA USERS
CREATE PROCEDURE FILTRA_USERS --MANDA TODOS LOS USUARIOS
AS
BEGIN
	SELECT *FROM USUARIO;
END

EXECUTE FILTRA_USERS
END

CREATE PROCEDURE VALIDAR_INICIOSESION(@user VARCHAR(25))--MANDA LA CONTRASEÑA DE CIERTO USUARIO
AS
BEGIN
	SELECT CONTRASENIA_U FROM USUARIO WHERE NOMBRE_U = @user;
END

EXECUTE VALIDAR_INICIOSESION 'perrito'

CREATE PROCEDURE GET_USERDATA(@user VARCHAR(25))--OBTIENE LA INFO DE CIERTO USUARIO
AS
BEGIN
	SELECT *FROM USUARIO WHERE NOMBRE_U = @user;
END

EXECUTE GET_USERDATA 'perrito'

DROP PROCEDURE EDIT_U_SIMPLE
CREATE PROCEDURE EDIT_U_SIMPLE( --EDITA TODOS LOS ATRIBUTOS DEL USUARIO,EXECPTO LA TARJETA
@u_nombre VARCHAR (25),
@u_newNombre VARCHAR (25),
@u_newContraseña VARCHAR (20),
@u_newCorreo VARCHAR (35),
@u_newCel VARCHAR (14)
)
AS
BEGIN
	BEGIN TRANSACTION
	BEGIN TRY
		UPDATE USUARIO SET CONTRASENIA_U = 'felipito' WHERE NOMBRE_U = 'richi';	
		UPDATE USUARIO SET CORREO_U = 'cre@mail' WHERE NOMBRE_U = 'richi';	
		UPDATE USUARIO SET NUM_CEL_U = '8100899200' WHERE NOMBRE_U = 'richi';
		UPDATE USUARIO SET NOMBRE_U = 'Rory' WHERE NOMBRE_U = 'Ricardo'; 
		SELECT @u_newNombre;
		COMMIT TRANSACTION
	END TRY
	BEGIN CATCH
		ROLLBACK TRANSACTION
		SELECT '.'
	END CATCH
END 
EXECUTE EDIT_U_SIMPLE 'richi','richie','felipito','core@mail','8100899200'
SELECT *fROM RESERVA
SELECT *fROM USUARIO

CREATE PROCEDURE CHECK_TARJETA(--REVISA SI LA TARJETA YA EXISTE EN EL SISTEMA
@u_tarjeta VARCHAR (17)
)
AS
BEGIN
	IF EXISTS(SELECT NUM_TARJETA FROM TARJETA WHERE NUM_TARJETA = @u_tarjeta)--existe a tarjeta
		BEGIN SELECT 'E'; END
	ELSE --no existe la tarjeta
		BEGIN SELECT 'NE'; END
END
EXECUTE CHECK_TARJETA '1134567890123456'

DROP PROCEDURE INSERT_TARJETA
CREATE PROCEDURE INSERT_TARJETA(
@u_newNumeroTarjeta VARCHAR (17),
@t_cvc INT,
@t_primerNombre VARCHAR (15),
@t_segundoNombre VARCHAR (15),
@t_primerApellido VARCHAR (15),
@t_segundoApellido VARCHAR (15),
@t_fechaVigencia INT
)
AS 
BEGIN
	
	INSERT INTO TARJETA
	VALUES (@t_cvc,@t_primerNombre,@t_segundoNombre,@t_primerApellido,@t_segundoApellido,@t_fechaVigencia,@u_newNumeroTarjeta);
	SELECT @u_newNumeroTarjeta
END
EXECUTE INSERT_TARJETA '0000',123,'itzelita',null,'cabrera',null,1220

DROP PROCEDURE EDIT_U_COMPLETE
CREATE PROCEDURE EDIT_U_COMPLETE(
@u_nombre VARCHAR (25),
--nuevos datos del usuario
@u_newNombre VARCHAR (25),
@u_newContraseña VARCHAR (20),
@u_newCorreo VARCHAR (35),
@u_newCel VARCHAR (14),
--datos de la nueva tarjeta
@u_newNumeroTarjeta VARCHAR (17),
@t_cvc INT,
@t_primerNombre VARCHAR (15),
@t_segundoNombre VARCHAR (15),
@t_primerApellido VARCHAR (15),
@t_segundoApellido VARCHAR (15),
@t_fechaVigencia INT
)
AS 
BEGIN
	IF NOT EXISTS(SELECT NUM_TARJETA FROM TARJETA WHERE NUM_TARJETA = @u_newNumeroTarjeta)
		BEGIN
			PRINT'NO EXISTE TARJETA'
			BEGIN TRANSACTION
			BEGIN TRY
				IF ((@t_segundoNombre = '0') AND (@t_segundoNombre = '0'))
					BEGIN 
						INSERT INTO TARJETA
						VALUES (@t_cvc,@t_primerNombre,NULL,@t_primerApellido,NULL,@t_fechaVigencia,@u_newNumeroTarjeta);
					END
				ELSE IF (@t_segundoNombre = '0')
					BEGIN 
						INSERT INTO TARJETA
						VALUES (@t_cvc,@t_primerNombre,NULL,@t_primerApellido,@t_segundoApellido,@t_fechaVigencia,@u_newNumeroTarjeta);
					END
				ELSE IF (@t_segundoApellido = '0')
					BEGIN 
						INSERT INTO TARJETA
						VALUES (@t_cvc,@t_primerNombre,@t_segundoNombre,@t_primerApellido,NULL,@t_fechaVigencia,@u_newNumeroTarjeta);
					END
				ELSE
					BEGIN
						INSERT INTO TARJETA
						VALUES (@t_cvc,@t_primerNombre,@t_segundoNombre,@t_primerApellido,@t_segundoApellido,@t_fechaVigencia,@u_newNumeroTarjeta);
					END
				UPDATE USUARIO SET CONTRASENIA_U = @u_newContraseña WHERE NOMBRE_U = @u_nombre;	
				UPDATE USUARIO SET CORREO_U = @u_newCorreo WHERE NOMBRE_U = @u_nombre;	
				UPDATE USUARIO SET NUM_CEL_U = @u_newCel WHERE NOMBRE_U = @u_nombre;
				UPDATE USUARIO SET NUM_TARJETA_U = @u_newNumeroTarjeta WHERE NOMBRE_U = @u_nombre;
				UPDATE USUARIO SET NOMBRE_U = @u_newNombre WHERE NOMBRE_U = @u_nombre;
				COMMIT TRANSACTION
				SELECT @u_newNombre;
			END TRY
			BEGIN CATCH
				PRINT 'ERROR AL EDITAR LOS DATOS COMPLETOS DEL USUARIO,INSERTANDO TARJETA'
				SELECT '.'
				ROLLBACK TRANSACTION
			END CATCH
		END
	ELSE
		BEGIN 
			PRINT 'YA EXISTE LA TARJETA'
			DECLARE @cvc INT;
			DECLARE @PN VARCHAR(15);
			DECLARE @SN VARCHAR(15);
			DECLARE @PA VARCHAR(15);
			DECLARE @SA VARCHAR(15);
			DECLARE @fecha INT;
			DECLARE @V INT; SET @V = 0;
			SET @cvc = (SELECT CVC FROM TARJETA WHERE NUM_TARJETA = @u_newNumeroTarjeta);
			SET @PN = (SELECT PRIMER_NOMBRE_T FROM TARJETA WHERE NUM_TARJETA = @u_newNumeroTarjeta);
			SET @SN = (SELECT SEGUNDO_NOMBRE_T FROM TARJETA WHERE NUM_TARJETA = @u_newNumeroTarjeta);
			SET @PA = (SELECT PRIMER_APELLIDO_T FROM TARJETA WHERE NUM_TARJETA = @u_newNumeroTarjeta);
			SET @SA = (SELECT SEGUNDO_APELLIDO_T FROM TARJETA WHERE NUM_TARJETA = @u_newNumeroTarjeta);
			SET @fecha = (SELECT FECHA_VIGENCIA FROM TARJETA WHERE NUM_TARJETA = @u_newNumeroTarjeta);
			
			IF (@cvc = @t_cvc) BEGIN SET @V = @V+1;PRINT 'CVC' END
			IF (@PN = @t_primerNombre) BEGIN SET @V = @V+1; PRINT 'PN' END
			IF (@PA = @t_primerApellido) BEGIN SET @V = @V+1;PRINT 'PA'  END
			IF (@fecha = @t_fechaVigencia) BEGIN SET @V = @V+1; PRINT 'FV' END
			IF (@SN IS NULL) 
				BEGIN 
					IF (@t_segundoNombre = '0') BEGIN SET @V = @V+1;PRINT 'SN'  END
				END
			ELSE 
				BEGIN 
					IF (@t_segundoNombre = @SN) BEGIN SET @V = @V+1;PRINT 'SN'  END
				END
			IF (@SA IS NULL) 
				BEGIN  
					IF (@t_segundoApellido = '0') BEGIN SET @V = @V+1;PRINT 'SA'  END
				END
			ELSE 
				BEGIN 
					IF (@t_segundoApellido = @SA) BEGIN SET @V = @V+1;PRINT 'SA'  END
				END

			PRINT @V;

			IF (@V = 6)
				BEGIN
					BEGIN TRANSACTION
					BEGIN TRY
						UPDATE USUARIO SET CONTRASENIA_U = @u_newContraseña WHERE NOMBRE_U = @u_nombre;	
						UPDATE USUARIO SET CORREO_U = @u_newCorreo WHERE NOMBRE_U = @u_nombre;	
						UPDATE USUARIO SET NUM_CEL_U = @u_newCel WHERE NOMBRE_U = @u_nombre;
						UPDATE USUARIO SET NUM_TARJETA_U = @u_newNumeroTarjeta WHERE NOMBRE_U = @u_nombre;
						UPDATE USUARIO SET NOMBRE_U = @u_newNombre WHERE NOMBRE_U = @u_nombre;
						COMMIT TRANSACTION
						SELECT @u_newNombre;
					END TRY
					BEGIN CATCH
						PRINT 'ERROR AL EDITAR LOS DATOS COMPLETOS DEL USUARIO,INSERTANDO TARJETA'
						ROLLBACK TRANSACTION
						SELECT '.'
					END CATCH
				END
			ELSE
				BEGIN
					PRINT 'DATOS INCORRECTOS'
					SELECT '.'
				END
		END
END

SELECT *FROM TARJETA
SELECT *FROM USUARIO
EXECUTE EDIT_U_COMPLETE 'richi','richi','rxd','richi@gmail','9980881293','1134567890123456',
987,'ANAHÍ','0','SALTO','CRUZ',123

CREATE PROCEDURE VERIFICAR_USUARIO(
	@nombreU VARCHAR(25)
)
AS
BEGIN
	SELECT NOMBRE_U FROM USUARIO WHERE NOMBRE_U = @nombreU;
END

DROP PROCEDURE VER_HISTORIAL_COMPRAS;
CREATE PROCEDURE VER_HISTORIAL_COMPRAS(
	@nombreU VARCHAR(25)
)
AS
BEGIN
	SELECT COD_R,PRIMER_NOMBRE_C,SEGUNDO_NOMBRE_C,
	PRIMER_APELLIDO_C,SEGUNDO_APELLIDO_C,FECHA_R,
	NOMBRE_TR,EST_I,EST_F,COSTO_R
	FROM RESERVA_USUARIO WHERE NOMBRE_U = @nombreU;
END 
execute VER_HISTORIAL_COMPRAS 'itzeeelcava'

DROP PROCEDURE VER_RESERVAS_CLIENTE;
CREATE PROCEDURE VER_RESERVAS_CLIENTE(
	@primerNombre VARCHAR (15),
	@segundoNombre VARCHAR (15),
	@primerApellido VARCHAR (15),
	@segundoApellido VARCHAR (15)
)
AS
BEGIN
	IF @segundoNombre=''
	BEGIN
		SELECT COD_R,FECHA_R,NOMBRE_TR,PRIMER_NOMBRE_C,SEGUNDO_NOMBRE_C,
		PRIMER_APELLIDO_C,SEGUNDO_APELLIDO_C,EDAD_C,NACIONALIDAD_C,COSTO_R
		FROM RESERVA_CLIENTE WHERE PRIMER_NOMBRE_C=@primerNombre AND 
		SEGUNDO_NOMBRE_C IS NULL AND PRIMER_APELLIDO_C=@primerApellido
		AND SEGUNDO_APELLIDO_C=@segundoApellido;
	END
	ELSE 
	BEGIN
		SELECT COD_R,FECHA_R,NOMBRE_TR,PRIMER_NOMBRE_C,SEGUNDO_NOMBRE_C,
		PRIMER_APELLIDO_C,SEGUNDO_APELLIDO_C,EDAD_C,NACIONALIDAD_C,COSTO_R
		FROM RESERVA_CLIENTE WHERE PRIMER_NOMBRE_C=@primerNombre AND 
		SEGUNDO_NOMBRE_C=@segundoNombre AND PRIMER_APELLIDO_C=@primerApellido
		AND SEGUNDO_APELLIDO_C=@segundoApellido;
	END
END--falta hacer este panel 
EXECUTE VER_RESERVAS_CLIENTE 'CLAUDIA','MARIEL','RIVAS','ANGELES'


