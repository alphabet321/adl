<%@ page import="java.io.*, javax.servlet.*, javax.servlet.http.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cookie Example</title>
</head>
<body>
    <h1>Cookie Example</h1>
    <%
        String username = request.getParameter("username"); // Get username from form data

        // Create a cookie with the username
        Cookie cookie = new Cookie("username", username);
        cookie.setMaxAge(24 * 60 * 60); // Set cookie expiration time to 1 day
        response.addCookie(cookie); // Add cookie to response

        // Retrieve the cookie
        Cookie[] cookies = request.getCookies(); // Get all cookies from request
        String storedUsername = null;
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("username")) {
                    storedUsername = c.getValue();
                    break;
                }
            }
        }
    %>
    <%-- Display the retrieved cookie value --%>
    <p>Stored Username: <%= storedUsername %></p>
</body>
</html>