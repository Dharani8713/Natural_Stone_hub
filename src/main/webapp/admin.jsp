<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<title>Admin Panel</title>
</head>
<body>
	<form action="admin" method="post">
		<center>
			<h2>Admin: Add Leaked Email</h2>

			<input type="text" name="email" placeholder="Leaked email" required />
			<input type="submit" value="Add" />
		</center>
	</form>
	<p><%=request.getAttribute("message") != null ? request.getAttribute("message") : ""%></p>
</body>
</html>
