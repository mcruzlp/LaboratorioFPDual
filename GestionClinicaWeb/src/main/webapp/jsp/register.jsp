<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Connection"%>
<%@page import="edu.laboratoriofpdual.conector.Conector"%>
<%@page import="edu.laboratoriofpdual.conector.MySQLConstants"%>
<%@page import="edu.laboratoriofpdual.dao.Especialista"%>
<%@page import="edu.laboratoriofpdual.manager.EspecialistasManager"%>

<!DOCTYPE html>
<html lang="es">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<!-- enlace a favicon -->
<link rel="shortcut icon" href="/clinicaweb/images/favicon.png"
	type="image/x-icon">
<title>Clinica Nilo-Registro</title>
<!-- Custom fonts for this template -->
<link href="/clinicaweb/vendor/fontawesome-free/css/all.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link href="/clinicaweb/css/sb-admin-2.css" rel="stylesheet">
</head>

<body class="bg-login-image">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-8 col-sm-10 col-md-8 col-lg-6">
				<div class="card border-0 shadow-lg my-5">
					<div class="card-body p-5">
						<div class="text-center">
							<h1 class="h4 text-gray-900 mb-2">Crea un usuario</h1>
						</div>
						<form class="user" method="get" id="nuevoUsuario" action="/clinicaweb/NuevoUsuario">
							<div class="row my-2">
								<input type="text" class="form-control form-control-user"
									name="inputName" placeholder="Nombre y apellidos" required>
							</div>
							<div class="row my-2">
                <input type="text" class="form-control form-control-user"
                  name="inputEspecialidad" placeholder="Especialidad">
              </div>
							<div class="row my-2">
								<input type="email" class="form-control form-control-user"
									name="inputEmail" placeholder="Email" required>
							</div>
							<div class="row my-2">
               <input type="tel" class="form-control form-control-user" name="inputTlfn" placeholder="TelÃ©fono">
              </div>
							<div class="row my-2">
								<div class="col-sm-6 mb-3 mb-sm-0">
									<input type="password" class="form-control form-control-user"
										name="inputPassword" placeholder="Contraseña" required>
								</div>
								<div class="col-sm-6">
									<input type="password" class="form-control form-control-user"
										name="repeatPassword" placeholder="Repite la contraseña" required>
								</div>
							</div>

							<a onclick="document.getElementById('nuevoUsuario').submit(); return false;" 
							class="btn btn-primary btn-user btn-block">Registrar
                usuario</a>
              <%
                        String mensaje = request.getParameter("Mensaje");
                        if (mensaje != null) {
                        %>
                        <div class="text-center">
                            <p><%=mensaje%></p>
                        </div>
                        <%
                        }
                        %>
						</form>
						<hr>
						<div class="text-center">
							<a class="small" href="forgot-password.jsp">¿Has olvidado la
								contraseña?</a>
						</div>
						<div class="text-center">
							<a class="small" href="index.jsp">¿Ya tienes una cuenta?</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript-->
	<script src="/clinicaweb/vendor/jquery/jquery.js"></script>
	<script src="/clinicaweb/vendor/bootstrap/js/bootstrap.bundle.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="/clinicaweb/vendor/jquery-easing/jquery.easing.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="/clinicaweb/js/sb-admin-2.js"></script>

</body>

</html>