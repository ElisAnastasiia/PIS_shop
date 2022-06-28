<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
    <head><title>Users</title></head>
     <body>
     <div>
          <button onclick="location.href='/app/shop/'">Home</button>
     </div>
     <form action="/app/shop/" method="post">
                  <div visible="hidden">
                      <input type="hidden" name="command" value="commandTopUp">
                  </div>

                  <label><b>Top up balance of user by id</b></label>
                  <input name="user_id" type="text" placeholder="Enter id" required>
                  <input name="amount" type="text" placeholder="Enter amount" required>
                  <button type="submit">Top Up</button>

     </form>
     <form action="/app/shop/" method="post">
                       <div visible="hidden">
                           <input type="hidden" name="command" value="deleteUser">
                       </div>

                       <label><b>Delete user by id</b></label>
                       <input name="user_id" type="text" placeholder="Enter id" required>
                       <button type="submit">Delete</button>

          </form>

    <c:forEach var="user" items="${requestScope.users}">
                    <p>user id = "${user.id()}" </p>
                    <p>user balance = "${user.balance()}" </p>
    <hr>
    </c:forEach>
</body>
</html>