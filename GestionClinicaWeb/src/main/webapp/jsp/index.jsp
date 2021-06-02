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
<title>Clinica Nilo-Login</title>
<!-- Custom fonts for this template-->
<link href="/clinicaweb/vendor/fontawesome-free/css/all.css" rel="stylesheet"
		type="text/css">
<link
		href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
		rel="stylesheet">
<!-- Custom styles for this template-->
<link href="/clinicaweb/css/sb-admin-2.css" rel="stylesheet">
</head>

<body class="bg-login-image">
		<div class="container">
				<div class="row justify-content-center">
						<div class="col-8 col-sm-10 col-md-8 col-lg-6">
								<div class="card border-0 shadow-lg my-5">
										<div class="card-body p-5">
												<div class="text-center">
														<h1 class="h4 text-gray-900 mb-4">Inicia sesión</h1>
												</div>
												<form class="user" method="post" action="/clinicaweb/Login"
														id="loginform">
														<div class="form-group">
																<input type="text" class="form-control form-control-user"
																		name="inputEmail" aria-describedby="emailHelp"
																		placeholder="Nombre de usuario">
														</div>
														<div class="form-group">
																<input type="password" class="form-control form-control-user"
																		name="inputPassword" placeholder="Contraseña">
														</div>
														<!-- <div class="form-group">
                                <div class="custom-control custom-checkbox small">
                                    <input type="checkbox" class="custom-control-input" id="customCheck">
                                    <label class="custom-control-label" for="customCheck">Recordar mis datos</label>
                                </div>
                            </div> -->
														<a
																onclick="document.getElementById('loginform').submit();"
																class="btn btn-primary btn-user btn-block">Entrar</a>
												</form>
												<hr>
												<div class="text-center">
														<a class="small" href="register.jsp">Crear usuario nuevo</a>
												</div>
												<div class="text-center">
														<a class="small" href="forgot-password.jsp">¿Has olvidado tu
																contraseña?</a>
												</div>
												<%
												String mensaje = (String)request.getAttribute("Mensaje"); 
												if (mensaje != null) {
												%>
												<div class="text-center">
														<p class="small" style="color:red"><%=mensaje%></p>
												</div>
												<%
												}
												%>
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