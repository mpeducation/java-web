<%@page import="com.educacionit.services.impl.ProductoServiceImpl"%>
<%@page import="com.educacionit.domain.Producto"%>
<%@page import="java.util.Collection"%>
<html>
	<head>
		<title>Educacion IT - Listado de productos</title>
		<jsp:include page="styles.jsp"></jsp:include>
	</head>
	
	<body>
		<jsp:include page="navbar.jsp"></jsp:include>
		
		<div class="container">
			<h1>Listado de productos</h1>
			
			<div class="row">
				<div class="col">
					<table class="table">
					  <thead>
					    <tr>
					      <th scope="col">ID</th>
					      <th scope="col">CODIGO</th>
					      <th scope="col">TITULO</th>
					      <th scope="col">PRECIO</th>
					      <th scope="col">TIPO</th>
					      <th scope="col">ACCIONES</th>
					    </tr>
					  </thead>
					  
					  <%
					    ProductoServiceImpl p = new ProductoServiceImpl();
					  
					  	Collection<Producto> productos = p.findAll();
					  %>
					  
					  <tbody>
					  
					  <% for(Producto aux: productos) { %>
					  
					    <tr>
					      <th scope="row"><%= aux.getId() %></th>
					      <td><%= aux.getCodigo() %></td>
					      <td><%= aux.getTitulo() %></td>
					      <td><%= aux.getPrecio() %></td>
					      <td><%= aux.getTipoProducto() %></td>
					      <td>
					      	<button class="btn btn-danger">Eliminar</button>
					      	<button class="btn btn-warning">Editar</button>	
					      </td>
					    </tr>
					    
					  <%
						}
					  %>
					   
					  </tbody>
					</table>
				</div>
			</div>
		</div>
	
	
		<jsp:include page="scripts.jsp"></jsp:include>
	</body>

</html>