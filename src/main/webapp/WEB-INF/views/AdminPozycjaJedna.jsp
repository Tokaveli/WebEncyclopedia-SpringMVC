<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${poz.nazwa}</title>
</head>
<body >
<style type="text/css">
/* <![CDATA[ */


fieldset{ border:1px black solid;
 margin-left: 8px;
    margin-right: 8px;
    padding-top: 1.35em;
    padding-bottom: 0.625em;
    padding-left: 0.75em;
    padding-right: 0.75em;
    border: 1px groove (internal value); }
/* ]]> */
</style>


<body>

<jsp:include page="_header.jsp" />

<jsp:include page="_menuAdmin.jsp" />

		<td>
			<table height="100%" weight="100%" style="background-color: white;">
					<tr align ="left" valign="top" height="100%" weight="100%">
						<td  align ="left" valign="top" weight="100%">
						<fieldset  >
							<legend>Nazwa:</legend>	
							<font size="7">${poz.nazwa}</font>	
							<font size="4"><a href="AdminUsuwanie.html?did=${poz.ID}">Usuń</a>	<a href="AdminDodajHaslo.html?id=${poz.ID}">Edytuj</a></font></font>	
						</fieldset >
							<fieldset >
							<legend>Kategoria:</legend>	
							<font size="5">${poz.dodatkoweDane.nazwa}<br></font></font>	
						</fieldset ><fieldset >
							<legend>Informacje:</legend>	
							<font size="6">${poz.informacje}<br/></font>
								
						</fieldset >	
						
						<fieldset >
							<legend>Komentarze:</legend>							
							<a href="AdminEdycjaKom.html?did=${poz.ID}">Edytuj komentarze </a>  
							<font size="3">${poz.komentarze}<br/></font>
								
								<table >                
               				        <form  action="AdminDodajKomentarz.html" >       
                       		<tr>
                       			<td>Dodawanie Komentarza:</td>
                       		</tr>
                    			<tr>
                    				<table>
                    				<tr>
                    				<td  align="center">Nick:</td>          
                        			<td align="center"><input type="text" name="login"  /></td>
                    				</tr>     
                    			<tr>
                    				<td  align="center">Treść:</td>    
                    				<td align="center"><input type="text" name="tresc"  /><input type="hidden" name="id" value="${poz.ID}" /></td>
                    				
                    			</tr>        
                    				
                    				      
                    				
                    				
                    			                     
                    			<tr>                        
                        			<td align="center" colspan="2"><input type="submit" value="Wstaw komentarz" /></td>
                        			</tr>
                        			</table>
                        		</tr>
                    			</table>
                			   </form>
                			  
						</fieldset >
						
						    
		
		

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