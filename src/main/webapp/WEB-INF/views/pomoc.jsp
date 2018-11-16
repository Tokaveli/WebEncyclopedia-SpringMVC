<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Strona główna</title>
</head>
<body >

<body>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="_header.jsp" />

<jsp:include page="_menu.jsp" />

		<td>
			<table height="100%" weight="100%" style="background-color: white;">
					<tr align ="left" valign="top" height="100%" weight="100%">
						<td  align ="left" valign="top" weight="100%">
						<br><font size="6">Pomoc</font>	<br><br>		
						
						<font size="5">Ogólne informacje:</font><br>
						<br><font size="4">Wikipedia jest to swoista encyklopedia w formie elektronicznej. Każdy może z niej korzystać zgłębiając tajniki wiedzy.<br> W czym tkwi siła wikipedii ? Zdecydowanie w jej użytkownikach! Każdy z nich jest odbiorcą informacji zawartych w niej ale może być jednocześnie twórcą i krytykiem.Sukces tej witryny tkwi w tym, że każdy może sam tworzyć hasła, dyskutować o nich i zgłaszać poprawki co czyni wikipedię wiarygodnym źródłem informacji. <BR>
						<BR>
					<font size="6">Opis menu:</font><br>		
						<ol>
						<li>Wszystkie hasła:<BR>
						Wyświetla wszystkie hasła dostępne aktualnie w Wikipedii. Klikając na nazwe hasła przechodzimy do strony z tym hasłem. Na stronie z hasłem możemy dodawać komentarze, zgłaszać nieprawidłowości w postach.</ud>
						<li>Dodaj hasło<BR>
						Pozwala na dodanie nowego hasła do wikipedii. Formularz dodawania składa sie z następujących pól:<BR>
							<ul>
								<li>Nazwa: w tym polu wprowadzamy nazwę nowego hasła (po niej wyszukuje wyszukiwarka dlatego trzeba dobrze zastanowić się nad wyborem nazwy)</li>
								<li>Informacje: tu umieszczamy treść naszego artykułu. (osoby znające html dla formatowania tekstu mogą używać znaczników htmlowych)</li>
								<li>Kategoria: jest to lista rozwijalna z której wybieramy najbardziej zbliżoną tematycznie kategorię do naszego artykułu gdy nie istnieje w bazie pasująca kategoria to wybierzmy kategorię brak</li>
								<li>Przycisk dodaj: po wciśnięciu tego przyciusku dodamy nowe hasło jego edycja będzie już niemożliwa. W celu dodanie jakichś zmian uprasza się o zgłaszanie hasła i w treści zgłoszenia umieszczaniu odpowiednich informacji zmian do wprowadzenia.</li>
							</ul></li>
						<li>Kategorie:<BR>
						Wyświetla wszystkie kategorie dostępne w serwisie.</li>
						<li>Pomoc: informacje dotyczące witryny oraz podstawowe informacje dotyczące jej obsługi.</li>
						<li>Kontakt: informacje dotyczące siedziby właścicieli witryny (adres, kontakt emailowy, numer telefonu, godziny otwarcia budynku siedziby firmy)</li>
						<li>Panel admina: jest to opcja tylko dla administratorów do części admina nie wejdziemy bez znania loginu i hasła</li>
						<li>Wyszukiwarka: tu wpisujemy nazwę haseł do wyszukania. Po wciśnięciu przycisku wyszukaj otrzymamy listę haseł spełniających kryteria wyszukiwania.</li></ul>
						
						<BR>
						Inne informacje: 
						<ul>
							<li>Zgłaszanie postów: ta funkcjonalność służy do zgłaszania haseł w których albo coś trzeba poprawić albo regulamin jest łamany. W treści zgłoszenia prosimy dokładne opisanie problemu</li>
							<li>Wstawianie komentarzy: umożliwia to dyskusje. Sugeruje się aby komentarze były tematycznie związane z hasłami</li></ul>
					
					
					Regulamin: 
						<ul>
							<li>Hasła: Zabrania się pisania nieprawdziwych artykułów, w ich treści używania wulgaryzmów. Hasła które nie przestrzegają tych zarządzeń będą usuwane.</li>
							<li>Komentarze: Zabrania się obrażania innych użytkowników, używania niecenzuralneego słownictwa, oraz propagowania rasistowskich, nietolerancyjnych wyrażeń</li>
							
						</font>		
						
						</td>
					</tr>
			</table>
		
		</td> 
		
		
	</tr>	

<jsp:include page="_footer.jsp" />



</body>










</body>
</html>