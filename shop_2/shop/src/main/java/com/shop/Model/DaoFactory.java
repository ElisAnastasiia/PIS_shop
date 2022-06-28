package com.shop.Model;

import com.shop.Model.Dao.*;

public class DaoFactory {
    public static UserDao createUserDao(){
        return new UserDao();
    }
    public static ProductDao createProductDao(){
        return new ProductDao();
    }
    public static UserRoleDao createUserRoleDao(){
        return new UserRoleDao();
    }
    public static CategoryDao createCategoryDao(){return new CategoryDao();}
    public static BucketDao createBucketDao(){
        return new BucketDao();
    }

}
