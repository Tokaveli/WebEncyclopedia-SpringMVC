<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Wszystkie hasła</title>
</head>
<body >

<body>
<jsp:include page="_header.jsp" />

<jsp:include page="_menuAdmin.jsp" />

		<td>
			<table height="100%" weight="100%" style="background-color: white;">
					<tr align ="left" valign="top" height="100%" weight="100%">
						<td  align ="left" valign="top" weight="100%">
							<c:if test="${empty listaPozycji}">

							<h1>Brak haseł</h1>

							</c:if>

							<c:if test="${not empty listaPozycji}">
	
							<c:forEach items="${listaPozycji}" var="pozycja">
	
							<font size="6"><a href="AdminPozycjeWszystkie.html?id=${pozycja.ID}">${pozycja.nazwa} </a></font><br> 
							<font size="5">${pozycja.dodatkoweDane.nazwa}</font>
							 <br> 	
							<font size="4"><a href="AdminUsuwanie.html?did=${pozycja.ID}">Usuń</a>	<a href="AdminDodajHaslo.html?id=${pozycja.ID}">Edytuj</a></font></font>
							<BR>
							________________________________________________________________________________	
							<BR>
							</c:forEach>
							</c:if>							
						
						</td>
					</tr>
			</table>
		
		</td> 
		
		
	</tr>	

<jsp:include page="_footer.jsp" />


</body>










</body>
</html>