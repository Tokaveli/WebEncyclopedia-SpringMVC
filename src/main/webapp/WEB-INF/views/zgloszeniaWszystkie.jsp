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
							<c:if test="${empty listaZgloszen}">

							<h1>Brak Zgloszen</h1>

							</c:if>

							<c:if test="${not empty listaZgloszen}">
	
							<c:forEach items="${listaZgloszen}" var="zgloszenie">
	
							<font size="6"><a href="AdminPozycjaJedna.html?id=${zgloszenie.getIdZglaszanegoHasla()}">${zgloszenie.getNazwaHasla()}</a></font> 	<br>
							<font size="5">${zgloszenie.getDataZgloszenia()} </a></font> 	<br>
							<font size="5">${zgloszenie.getTrescZgloszenia()} </a></font> 	<br>
							
							<font size="4"><a href="usuwanieZgloszenia.html?did=${zgloszenie.getId()}">Usuń</a></font>
							<BR>
							________________________________________________________________________________	
							<BR>
							<BR>
	
	
	</c:forEach>

</c:if>
<br>
<br>


						
						
						</td>
					</tr>
			</table>
		
		</td> 
		
		
	</tr>	

<jsp:include page="_footer.jsp" />



</body>










</body>
</html>