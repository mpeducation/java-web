<!DOCTYPE html>
<html lang="es">
	<head>
		<meta charset="utf-8">
		<title>Ingreso de usuario</title>
		<jsp:include page="styles.jsp"></jsp:include>
	</head>
	
	<body>
		<jsp:include page="navbar.jsp"></jsp:include>
		
		<div class="container">
			
			
			<h1 class="mb-3 mt-4">Login - Ingreso de usuario</h1>
			
			<form action="loginController.jsp" class="p-5 border border-success w-50 m-auto"> <!-- method=GET (Viaja por la URL) => method=POST (Viaja el cuerpo de la petici�n) -->
				
				<div class="mb-3">
  				  <label for="lbl-username" class="form-label">Usuario:</label>
				  <input type="text" class="form-control" id="lbl-username" name="username" placeholder="Ingrese su usuario">
				</div>
				
				<div class="mb-3">
  				  <label for="lbl-password" class="form-label">Contrase�a:</label>
				  <input type="text" class="form-control" id="lbl-password" name="password" placeholder="Ingrese su Contrase�a">
				</div>
				
				<input type="submit" class="btn btn-success" value="Enviar">
			</form>
		</div>
		
		<jsp:include page="scripts.jsp"></jsp:include>
	</body>
	
</html>