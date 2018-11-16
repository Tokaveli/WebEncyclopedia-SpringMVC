<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
	background-color:  #003d3b;
	border: 3px double  #003d3b;
}

dt {
	width: 200px;
	padding: 7px 15px;
	font-weight: bold;
	font-size: larger;
	background-color: #005a51;
	color:  #003d3b;
	text-align: centre;
	border-right: 50px solid #005a51;
	margin-top: 1px;
}

dd {
	border-top: 1px solid  #003d3b;
}

dl a:link, dl a:visited {
	display: block;
	width: 200px;
	text-decoration: none;
	padding: 7px;
	font-weight: bold;
	background-color: #005a51;
	color: #def;
	border-left: 10px solid #005a51;
}

dl a:hover {
	width: 200px;
	background-color: #005a51;
	color: #fff;
	border-left: 20px solid #003d3b;
}


/* ]]> */
</style>


<table weight="100%" height="100%" >
	<tr>
		<td valign="top"> 
			<table>
			    <tr>
			    	<td><dl>
						<dt>Menu</dt>
						<dd><a href="AdminPozycjeWszystkie.html">Wszystkie hasła</a></dd>
						<dd><a href="AdminDodajHaslo.html">Dodaj hasło</a></dd>
						<dd><a href="AdminKategorieWszystkie.html">Kategorie</a></dd>
						<dd><a href="AdminKategoriaDodawanieEdycja.html">Dodaj nową kategorie</a></dd>
						<dd><a href="zgloszeniaWszystkie.html">Zgloszenia</a></dd>
						<dd><a href="pomoc.html">Pomoc</a></dd>
						<dd><a href="kontakt.html">Kontakt</a></dd>
						<dd><a href="<c:url value="/j_spring_security_logout" />" > Logout</a></dd>
						</dl>	
					</td>										
			    </tr>
			    <tr >
			    	<td  style="background-color: #005a51;" weight="100%">
			    		
 
            			<table  border="0" weight="100%">                
               				        <form  action="AdminWyszukajPozycje.html" >       
                       			<tr>
                        		<td  align="centre"><font color="#ccffff">Nazwa hasła do wyszukania:</font></td>            
                        			
                    			</tr>    
                    			<tr>
                    				<td align="center"><input type="text" name="nazwa"  /></td>
                    			</tr>                      
                    			<tr>                        
                        			<td align="center" colspan="2"><input type="submit" value="Wyszukaj" /></td>
                    			</tr>
                			   </form>         
           			 </table>
 						       	
			    	</td>
			    </tr>
			</table>
		</td>