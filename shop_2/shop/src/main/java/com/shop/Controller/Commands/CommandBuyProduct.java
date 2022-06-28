package com.shop.Controller.Commands;

import com.shop.Model.Entities.Product;
import com.shop.Model.Entities.User;
import com.shop.Service.ProductService;
import com.shop.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandBuyProduct implements ICommand{
    UserService userService = new UserService();
    ProductService productService = new ProductService();
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("registered") == null)
            return ECommand.home.getCommand().execute(request);
        Boolean registered = (Boolean) session.getAttribute("registered");
        if(registered) {
            User user = (User) session.getAttribute("user");
            Integer user_id = user.id();
            Integer product_id = Integer.parseInt(request.getParameter("product_id"));
            Integer balance = user.balance()-productService.getProductById(product_id).price();
            if(balance < 0){
                request.setAttribute("isEmpty", true);
                return ECommand.productsList.getCommand().execute(request);
            }
            else {
                productService.addInBucket(user_id, product_id);
                session.setAttribute("user", new User(
                        user.id(),
                        user.username(),
                        user.password(),
                        balance));
            }
        }
        return ECommand.productsList.getCommand().execute(request);
    }
}
