package com.shop.Model.Dao;

import com.shop.Model.Entities.Product;
import com.shop.Model.Entities.User;

import java.sql.*;
import java.util.ArrayList;

public class ProductDao implements IDao<Product> {
    final static private String SELECT = "select * from product where id = ?";
    final static private String SELECTALL = "select * from product";
    final static private String INSERT = "insert into product (name, price, category) values(?, ?, ?)";
    final static private String DELETE = "delete from product where id = ?";
    final static private String UPDATE = "update product set name = ?, price = ?, category = ? where id = ?";
    @Override
    public Product findById(Integer id) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(SELECT);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new Product(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getInt(4));
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Product> findAll() {
        ArrayList<Product> products = new ArrayList<>();
        try(Connection c = dataSource.getConnection()){
            Statement ps = c.createStatement();
            ResultSet rs = ps.executeQuery(SELECTALL);
            while(rs.next()){
                products.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4)
                ));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public void add(Product entity) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(INSERT);
            ps.setString(1, entity.name());
            ps.setInt(2, entity.price());
            ps.setInt(3, entity.category());
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
    public void update(Product entity) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(UPDATE);
            ps.setString(1, entity.name());
            ps.setInt(2, entity.price());
            ps.setInt(3, entity.category());
            ps.setInt(4, entity.id());
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
