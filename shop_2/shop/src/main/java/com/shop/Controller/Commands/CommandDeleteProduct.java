package com.shop.Controller.Commands;

import com.shop.Controller.ConfigPath;
import com.shop.Service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandDeleteProduct implements ICommand{
    ProductService productService = new ProductService();
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("admin") == null)
            return ConfigPath.home.getJspPath();
        Boolean admin = (Boolean) session.getAttribute("admin");
        if(admin) {
            productService.deleteProduct(Integer.parseInt(request.getParameter("product_id")));
        }
        return ECommand.productsList.getCommand().execute(request);
    }
}
