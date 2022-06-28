package com.shop.Controller.Commands;

import com.shop.Controller.ConfigPath;
import com.shop.Model.Entities.User;
import com.shop.Service.ProductService;
import com.shop.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandProfile implements ICommand{
    UserService userService = new UserService();
    ProductService productService = new ProductService();
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("registered") == null)
            return ConfigPath.home.getJspPath();
        Boolean registered = (Boolean) session.getAttribute("registered");
        if(registered){
            Integer id = ((User)session.getAttribute("user")).id();
            request.setAttribute("products", productService.getUserBucket(id));
            return ConfigPath.profile.getJspPath();
        }
        return ConfigPath.home.getJspPath();
    }
}
