<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
    <head><title>Profile</title></head>
     <body>
     <div>
          <button onclick="location.href='/app/shop/'">Home</button>
     </div>

         <p>user name = "${user.username()}" </p>
          <p>user balance = "${user.balance()}"</p>
        <h3>Bucket</h3>
        <c:forEach var="product" items="${requestScope.products}">
                            <p>product id = "${product.id()}" </p>
                            <p>product name = "${product.name()}" </p>
                            <p>product price = "${product.price()}" </p>
                            <p>product category = "${product.category()}" </p>
            <hr>
            </c:forEach>
</body>
</html>