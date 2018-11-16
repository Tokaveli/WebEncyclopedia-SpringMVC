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

		</td>
		<td>
			<table height="100%" weight="100%" style="background-color: white;">
					<tr align ="left" valign="top" height="100%" weight="100%">
						<td  align ="left" valign="top" weight="100%">
							
							<table>
							<tr>
							 	<form action="AdminEdycjaKom2.html">
	<textarea name="kom" cols="40" rows="30">${komentarze}</textarea><input type="hidden" name="id" value="${id}" />
</tr>
                   
                        <tr align="center">
                        <input type="submit" value="Zapisz zmiany" />
                        </tr>
                                  
           </form>
       </table>
						
						</td>
					</tr>
			</table>
		
		</td> 
		
		
	</tr>	

<jsp:include page="_footer.jsp" />



</body>










</body>
</html>