<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Result</title></head>
<body>
	<center>
    <h2>Result for: ${email}</h2>
    <p>
        <% Boolean leaked = (Boolean)request.getAttribute("isLeaked"); %>
        <% if (leaked != null && leaked) { %>
            <span style="color:red;">[Warning] Email has been leaked!</span>
        <% } else { %>
            <span style="color:green;">[Protected] Email is safe.</span>
        <% } %>
    </p>
    
    <a href="index.html">Check another email</a>
    </center>
</body>
</html>
