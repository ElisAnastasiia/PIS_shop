package com.shop;

import com.shop.Model.Dao.CategoryDao;
import com.shop.Model.Dao.UserDao;
import com.shop.Model.DaoFactory;
import com.shop.Model.Entities.Category;
import com.shop.Model.Entities.User;

public class Entry {
    public static void main(String[] args) {
        UserDao userDao = DaoFactory.createUserDao();
//        userDao.add(new User(null,"123","123",0));
//        System.out.println(userDao.findAll());
        CategoryDao categoryDao = DaoFactory.createCategoryDao();
//        categoryDao.add(new Category(null,"234"));
        categoryDao.delete(1);
    }
}
