<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dodawanie kategori</title>
</head>
<body >
<body>
<jsp:include page="_header.jsp" />

<jsp:include page="_menuAdmin.jsp" />

		<td>
			<table height="100%" weight="100%" style="background-color: white;">
					<tr align ="left" valign="top" height="100%" weight="100%">
						<td  align ="left" valign="top" weight="100%">
						<form:form  commandName="kategoria" >
 
            <table border="0">                
                <tbody>                
                       <tr> <font size="5">Dodawanie kategorii</font>
                     
                    </tr>       
                    <tr>
                        <td>Nazwa:</td>                        
                        <td><form:input path="nazwa" /> </td>
                    </tr>
                    <tr>
                        <td></td>                 
                        <td><form:errors path="nazwa" cssStyle="color:red" /></td>                      
                    </tr>               
                    <tr>
                        <td></td>
                        <td colspan="2"><input type="submit" value="dodaj" /></td>
                    </tr>
                  
                </tbody>                
            </table>
            </form:form>
          


						</td>
					</tr>
			</table>
		
		</td> 
		
		
	</tr>	

<jsp:include page="_footer.jsp" />


</body>










</body>
</html>