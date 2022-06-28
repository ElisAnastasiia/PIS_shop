<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Shop</title>
</head>
<body>
<div>
    <h1>Shop</h1>
</div>

<div>
    <div>
        <button onclick="location.href='/app/shop/?command=login'">Login</button>
        <button onclick="location.href='/app/shop/?command=register'">Register</button>
        <c:if test = "${sessionScope.admin == true}">
            <button onclick="location.href='/app/shop/?command=usersList'">Users</button>
        </c:if>
            <button onclick="location.href='/app/shop/?command=productsList'">Products</button>
        <c:if test = "${sessionScope.registered == true}">
                                    <button onclick="location.href='/app/shop/?command=commandProfile'">Profile</button>
                        </c:if>
        <c:if test = "${sessionScope.registered == true}">
                    <button onclick="location.href='/app/shop/?command=logOut'">LogOut</button>
        </c:if>

    </div>
</div>
</body>
</html>