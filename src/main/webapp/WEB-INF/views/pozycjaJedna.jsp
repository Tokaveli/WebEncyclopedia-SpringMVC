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
<body style=" word-wrap:break-word; max-width:100%;">
<style type="text/css">
/* <![CDATA[ */
dl, dt, dd {
	display: block;
	margin: 0;
	padding: 0;
}

dl {
	width: 200px;
	padding: 1px 2px;
	background-color: #9ce;
	border: 3px double #28e;
}

dt {
	width: 200px;
	padding: 7px 15px;
	font-weight: bold;
	font-size: larger;
	background-color: #25b;
	color: #9ce;
	text-align: right;
	border-right: 20px solid #26d;
	margin-top: 1px;
}

dd {
	border-top: 1px solid #9ce;
}

dl a:link, dl a:visited {
	display: block;
	width: 200px;
	text-decoration: none;
	padding: 7px;
	font-weight: bold;
	background-color: #27c;
	color: #def;
	border-left: 10px solid #25b;
}

dl a:hover {
	width: 200px;
	background-color: #28e;
	color: #fff;
	border-left: 20px solid #26d;
}

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
<jsp:include page="_menu.jsp" />

		<td>
			<table height="100%" weight="100%" style="background-color: white; word-wrap:break-word; max-width:100%;">
					<tr align ="left" valign="top" height="100%" weight="100%">
						<td  align ="left" valign="top" weight="100%">
						<fieldset  >
							<legend>Nazwa:</legend>	
							<font size="7">${poz.nazwa}</font>		
						</fieldset >
							<fieldset >
							<legend>Kategoria:</legend>	
							<font size="5">${poz.dodatkoweDane.nazwa}<br></font></font>	
						</fieldset style=" word-wrap:break-word; max-width:100%;"><fieldset >
							<legend>Informacje:</legend>	
							<font size="6">${poz.informacje}<br/></font>
								
						</fieldset >	
						<fieldset>
						<legend>Zgłaszanie błędów:</legend>	
						 <form  action="dodajZgloszenie.html" >       
                       		
                       		
                    			
                    				Treść zgłoszenia: <BR> 
                    				<input type="text" name="tresc"  />
                    				<input type="hidden" name="idd" value="${poz.ID}" />
                    				    			                     
                    				                        
                        			<input type="submit" value="Zgłoś" />
                        			
                        		
                    			
                			   </form>
						</fieldset>
						               
               				       
						
						<fieldset  >
							<legend>Komentarze:</legend>							
							
							<font size="3" >${poz.komentarze}<br/></font>
								
								<table >                
               				        <form  action="DodajKomentarz.html" >       
                       		<tr>
                       			<td>Dodawanie Komentarza:</td>
                       		</tr>
                    			<tr>
                    				<table>
                    				<tr>
                    				<td  align="center">Nick:</td>          
                        			<td align="center"><input type="text" name="login" /></td>
                    				</tr>     
                    				<tr>
                    				<td  align="center">Treść:</td>    
                    				<td align="center"><input type="text" name="tresc" /><input type="hidden" name="id" value="${poz.ID}" /></td>
                    				
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