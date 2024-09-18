<%--
  Created by IntelliJ IDEA.
  User: Nga
  Date: 9/16/2024
  Time: 3:07 PM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Tạo tài khoản mới</title>
</head>
<body>
<!-- Thông báo alert nếu có -->
<c:if test="${alert != null}">
    <h3 class="alert alert-danger">${alert}</h3>
</c:if>

<form action="login" method="post"> <!-- Sửa dấu ngoặc kép ở đây -->
    <h2>Tạo tài khoản mới</h2>
    <section>
        <label class="input login-input">
            <div class="input-group">
                <span class="input-group-addon">
                    <i class="fa fa-user"></i>
                </span>
                <input type="text" placeholder="Tài khoản" name="username" class="form-control">
            </div>
        </label>
        <br>
        <label class="input login-input">
            <div class="input-group">
                <span class="input-group-addon">
                    <i class="fa fa-user"></i>
                </span>
                <input type="password" placeholder="Mật khẩu" name="password" class="form-control">
            </div>
        </label>
        <br>
        <input type="submit">
    </section>
</form>
</body>
</html>
