<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f9;
      margin: 0;
      padding: 0;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }

    a {
      text-decoration: none;
      background-color: #4CAF50;
      color: white;
      padding: 10px 20px;
      border-radius: 5px;
      font-size: 16px;
      transition: background-color 0.3s ease;
    }

    a:hover {
      background-color: #45a049;
    }

    a:active {
      background-color: #3e8e41;
    }
  </style>
</head>
<body>
<a href="${pageContext.request.contextPath}/login">Login</a>
<a href="${pageContext.request.contextPath}/register">Register</a>
</body>
</html>
