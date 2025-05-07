<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detalle de Receta</title>
    <link rel="stylesheet" href="/css/estilos.css">
</head>
<body>
    <h1>Detalle de la Receta</h1>

    <c:if test="${not empty error}">
        <p style="color: red;">${error}</p>
        <a href="/recetas">Volver a la lista</a>
    </c:if>

    <c:if test="${empty error}">
        <h2>${nombreReceta}</h2>
        <ul>
            <c:forEach var="ingrediente" items="${ingredientes}">
                <li>${ingrediente}</li>
            </c:forEach>
        </ul>
        <a href="/recetas">Volver a la lista</a>
    </c:if>

</body>
</html>
