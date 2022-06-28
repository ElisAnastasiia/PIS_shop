package com.shop.Controller.Commands;

import com.shop.Model.Entities.Product;
import com.shop.Service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandAddProduct implements ICommand{
    ProductService productService = new ProductService();
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("admin") == null)
            return ECommand.home.getCommand().execute(request);
        Boolean admin = (Boolean) session.getAttribute("admin");
        if(admin) {
            productService.addProduct(new Product(
                    null,
                    request.getParameter("name"),
                    Integer.parseInt(request.getParameter("price")),
                    Integer.parseInt(request.getParameter("category"))
            ));
        }
        return ECommand.productsList.getCommand().execute(request);
    }
}
