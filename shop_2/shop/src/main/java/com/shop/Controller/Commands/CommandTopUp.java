package com.shop.Controller.Commands;

import com.shop.Controller.ConfigPath;
import com.shop.Model.Entities.User;
import com.shop.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandTopUp implements ICommand{
    UserService userService = new UserService();
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("admin") == null)
            return ConfigPath.home.getJspPath();
        Boolean admin = (Boolean) session.getAttribute("admin");
        if(admin) {
            User user = userService.getUserById(Integer.parseInt(request.getParameter("user_id")));
            if(user == null) return ECommand.usersList.getCommand().execute(request);
            User updatedUser = new User(
                    user.id(),
                    user.username(),
                    user.password(),
                    user.balance()+Integer.parseInt(request.getParameter("amount")));
            userService.updateUser(updatedUser);
            session.setAttribute("user", updatedUser);
            return ECommand.usersList.getCommand().execute(request);
        }
        return ConfigPath.home.getJspPath();
    }
}
