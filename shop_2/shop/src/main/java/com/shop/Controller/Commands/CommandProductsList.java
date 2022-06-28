package com.shop.Controller.Commands;

import com.shop.Controller.ConfigPath;
import com.shop.Service.CategoryService;
import com.shop.Service.ProductService;
import com.shop.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandProductsList implements ICommand{
    ProductService productService = new ProductService();
    CategoryService categoryService = new CategoryService();
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Boolean registered = (Boolean) session.getAttribute("registered");
        if(registered == null){
            return ConfigPath.home.getJspPath();
        }
        if(registered){
            String category = request.getParameter("searchCategory");
            if(category != null)
                request.setAttribute("products", productService.getProductsByCategory(Integer.parseInt(category)));
            else
                request.setAttribute("products", productService.getAll());
            request.setAttribute("categories", categoryService.getAll());
            return ConfigPath.products.getJspPath();
        }
        return ConfigPath.home.getJspPath();
    }
}
