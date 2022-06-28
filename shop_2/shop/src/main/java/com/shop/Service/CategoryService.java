package com.shop.Service;

import com.shop.Model.Dao.CategoryDao;
import com.shop.Model.DaoFactory;
import com.shop.Model.Entities.Category;

import java.util.ArrayList;

public class CategoryService {
    CategoryDao categoryDao = DaoFactory.createCategoryDao();
    public ArrayList<Category> getAll(){
        return categoryDao.findAll();
    }
}
