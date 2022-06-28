package com.shop.Model.Dao;

import com.shop.Model.Entities.Bucket;
import com.shop.Model.Entities.UserRole;

import java.sql.*;
import java.util.ArrayList;

public class BucketDao implements IDao<Bucket> {
    final static private String SELECT = "select * from bucket where user_id = ?";
    final static private String SELECTALL = "select * from bucket";
    final static private String INSERT = "insert into bucket (user_id, product_id) values(?, ?)";
    final static private String DELETE = "delete from bucket where user_id = ?";
    final static private String UPDATE = "update bucket set product_id = ? where user_id = ?";
    @Override
    public Bucket findById(Integer id) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(SELECT);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return new Bucket(
                    rs.getInt(1),
                    rs.getInt(2)
            );
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Bucket> findAll() {
        ArrayList<Bucket> buckets = new ArrayList<>();
        try(Connection c = dataSource.getConnection()){
            Statement ps = c.createStatement();
            ResultSet rs = ps.executeQuery(SELECTALL);
            while(rs.next()){
                buckets.add(new Bucket(
                        rs.getInt(1),
                        rs.getInt(2))
                );
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return buckets;
    }

    @Override
    public void add(Bucket entity) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(INSERT);
            ps.setInt(1, entity.user_id());
            ps.setInt(2, entity.product_id());
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
    public void update(Bucket entity) {
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement(UPDATE);
            ps.setInt(1, entity.product_id());
            ps.setInt(2, entity.user_id());
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
