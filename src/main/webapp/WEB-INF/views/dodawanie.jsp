<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Strona główna</title>
</head>
<body >
<body>
<jsp:include page="_header.jsp" />

<jsp:include page="_menu.jsp" />

		<td>
			<table height="100%" weight="100%" style="background-color: white;">
					<tr align ="left" valign="top" height="100%" weight="100%">
						<td  align ="left" valign="top" weight="100%">
						<form:form  commandName="pozycja" >
 
            <table border="0">                
                <tbody>                
                        
                    <tr>
                        <td>Nazwa:</td>                        
                        <td><form:input path="nazwa" /> </td>
                    </tr>
                    <tr>
                        <td></td>                 
                        <td><form:errors path="nazwa" cssStyle="color:red" /></td>                      
                    </tr>               
                   
                    <tr>
                        <td>Informacje:</td>
                        <td><form:textarea path="informacje" rows="3" cols="50" />
                    </tr>
                     
                    <tr>
                        <td></td>                       
                        <td><form:errors path="informacje" cssStyle="color:red" /></td>                      
                    </tr>
                    
                    <tr>
                        <td>Kategoria</td>
                        <td><form:select path="dodatkoweDane.ID" items="${listaKategorii}" itemLabel="nazwa" itemValue="ID"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td colspan="2"><input type="submit" value="dodaj" /></td>
                    </tr>
                </tbody>                
            </table>
            </form:form>
            <a href="pozycjeWszystkie.html">Wszystkie hasła</a><br>

						</td>
					</tr>
			</table>
		
		</td> 
		
		
	

<jsp:include page="_footer.jsp" />



</body>










</body>
</html>