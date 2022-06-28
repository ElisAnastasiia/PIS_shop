<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
    <head><title>Products</title></head>
     <body>
     <div>
          <button onclick="location.href='/app/shop/'">Home</button>
     </div>
     <form action="/app/shop/" method="post">
                                      <div visible="hidden">
                                          <input type="hidden" name="command" value="addProduct">
                                      </div>

                                      <label><b>Add product</b></label>
                                      <input name="name" type="text" placeholder="Enter name" required>
                                      <input name="price" type="text" placeholder="Enter price" required>
                                    <select id="category" name="category" >
                                    <c:forEach var="category" items="${requestScope.categories}">
                                              <option value="${category.id()}"> ${category.name()} </option>
                                    </c:forEach>
                                        </select>
                                      <button type="submit">Add</button>

                         </form>
    <form action="/app/shop/" method="post">
                       <div visible="hidden">
                           <input type="hidden" name="command" value="deleteProduct">
                       </div>

                       <label><b>Delete product by id</b></label>
                       <input name="product_id" type="text" placeholder="Enter id" required>
                       <button type="submit">Delete</button>

          </form>
    <h3>Get products by category</h3>
    <form action="/app/shop/" method="post">
                                          <div visible="hidden">
                                              <input type="hidden" name="command" value="productsList">
                                          </div>
                                        <select id="searchCategory" name="searchCategory" >
                                        <c:forEach var="category" items="${requestScope.categories}">
                                                  <option value="${category.id()}"> ${category.name()} </option>
                                        </c:forEach>
                                            </select>
                                          <button type="submit">Find</button>

                             </form>

    <c:if test = "${isEmpty == true}">
                             <p>Not enough on balance!<p>
                    </c:if>

    <c:forEach var="product" items="${requestScope.products}">
                    <p>product id = "${product.id()}" </p>
                    <p>product name = "${product.name()}" </p>
                    <p>product price = "${product.price()}" </p>
                    <p>product category = "${product.category()}" </p>
                    <form action="/app/shop/" method="post">
                                           <div visible="hidden">
                                               <input type="hidden" name="command" value="buyProduct">
                                           </div>
                                            <div visible="hidden">
                                                 <input type="hidden" name="product_id" value="${product.id()}">
                                            </div>
                       <button type="submit">Buy</button>
                    </form>

    <hr>
    </c:forEach>
</body>
</html>