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
			
			<jsp:include page="mensajeria.jsp" />
			
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
					      	<button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#eliminar" onclick="guardarId( <%= aux.getId() %>)">Eliminar</button>
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
		
		<!-- MODAL -->
		<div class="modal fade" id="eliminar" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h1 class="modal-title fs-5" id="exampleModalLabel">Eliminar Producto</h1>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        �Desea eliminar el producto?
		      </div>
		      <div class="modal-footer">
		      	<form id="eliminarFOrm" action="<%=request.getContextPath()%>/EliminarProductoServlet">
		      		<input name="id" type="hidden" id="idProductoEliminar">
		      		
		      		<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
		        	<button type="submit" class="btn btn-primary">Confirmar</button>
		      	</form>
		      </div>
		    </div>
		  </div>
		</div>
	
	
		<jsp:include page="scripts.jsp"></jsp:include>
		
		<script>
			function guardarId(id) {
				document.getElementById('idProductoEliminar').value = id;
			}
		</script>
		
	</body>

</html>