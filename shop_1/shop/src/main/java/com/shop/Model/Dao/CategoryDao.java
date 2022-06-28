package com.shop.Model.Dao;

import com.shop.Model.Entities.Category;

import java.sql.*;
import java.util.ArrayList;

public class CategoryDao implements IDao<Category> {
    final static private String SELECT = "select * from category where id = ?";
    final static private String SELECTALL = "select * from category";
    final static private String INSERT = "insert into category (name) values(?)";
    final static private String DELETE = "delete from category where id = ?";
    final static private String UPDATE = "update category set name = ? where id = ?";
    @Override
    public Category findById(Integer id) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(SELECT);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new Category(
                    rs.getInt(1),
                    rs.getString(2)
            );
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Category> findAll() {
        ArrayList<Category> categories = new ArrayList<>();
        try(Connection c = dataSource.getConnection()){
            Statement ps = c.createStatement();
            ResultSet rs = ps.executeQuery(SELECTALL);
            while(rs.next()){
                categories.add(new Category(
                        rs.getInt(1),
                        rs.getString(2))
                );
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public void add(Category entity) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(INSERT);
            ps.setString(1, entity.name());
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(DELETE);
            ps.setInt(1, id);
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Category entity) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(UPDATE);
            ps.setString(1, entity.name());
            ps.setInt(2, entity.id());
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
