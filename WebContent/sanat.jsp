<%@page import="java.util.ArrayList"%>
<%@page import="fi.softala.jee.demo.d18.bean.Sana"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sanat</title>
</head>
<body>
	<%
		ArrayList<Sana> sanat = new ArrayList<Sana>();
		sanat = (ArrayList<Sana>) request.getAttribute("sanat");
	%>
	<p>
	<a href="lisaa.jsp">Lisää sana</a>.
	</p>
	<p>
	Tilastot.
		<%
			int inaraSanat = 0;
			int jukkaSanat = 0;
			for (int i = 0; i < sanat.size(); i++) {
				if(sanat.get(i).getKayttaja().getKayttajatunnus().equals("inara")) {
					inaraSanat++;
				} else {
					jukkaSanat++;
				}
			}
			out.println("Inara: " + inaraSanat + " Jukka: " + jukkaSanat + ".");
		%>

	</p>
	<table border="1">
		<tr>
			<th>Uusi sana</th>
			<th>Seloste</th>
			<th>Käyttäjä</th>

		</tr>
		<%
			for (int i = 0; i < sanat.size(); i++) {
				out.println("<tr>");
				out.println("<td>");
				out.println(sanat.get(i).getSana());
				out.println("</td>");
				out.println("<td>");
				out.println(sanat.get(i).getSeloste());
				out.println("</td>");
				out.println("<td>");
				out.println(sanat.get(i).getKayttaja().getKayttajatunnus());
				out.println("</td>");
				out.println("</tr>");
			}
		%>
	</table>

</body>
</html>