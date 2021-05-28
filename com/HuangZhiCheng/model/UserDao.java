package com.HuangZhiCheng.dao;

import com.HuangZhiCheng.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDao implements IUerDao{

    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        String sql = "update usertable set username=?,password=?,email=?,gender=?,birthdate=? where id=?";
        PreparedStatement pre = con.prepareStatement(sql);

        pre.executeUpdate();
        return true;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        String sql = "delete * from usertable where id=?";
        PreparedStatement pre = con.prepareStatement(sql);
        pre.setInt(1,user.getId());
        return pre.executeUpdate();
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        //用id查找并且更新数据库中数据
        String sql = "update usertable set username=?,password=?,email=?,gender=?,birthDate=? where id=?";
        PreparedStatement pre = con.prepareStatement(sql);
        pre.setString(1,user.getUsername());
        pre.setString(2,user.getPassword());
        pre.setString(3,user.getEmail());
        pre.setString(4,user.getGender());
        pre.setDate(5,(java.sql.Date) user.getBirthDate());
        pre.setInt(6,user.getId());
        return pre.executeUpdate();
    }

    @Override
    public int insertUser(Connection con, User user) throws SQLException {
        String sql = "insert into usertable values(null,?,?,?,?,?)";
        PreparedStatement pre = con.prepareStatement(sql);
        pre.setString(1,user.getUsername());
        pre.setString(2,user.getPassword());
        pre.setString(3,user.getEmail());
        pre.setString(4,user.getGender());
        pre.setObject(5,user.getBirthDate());
        return pre.executeUpdate();

    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        String sql = "select * from usertable where id=?";
        PreparedStatement pre = con.prepareStatement(sql);
        pre.setInt(1,id);
        ResultSet resultSet = pre.executeQuery();
        User user = new User();
        while(resultSet.next()){
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setGender(resultSet.getString("gender"));
            user.setBirthDate(resultSet.getDate("birthdate"));
        }
        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        String sql="select * from usertable where username=? and password=?";
        PreparedStatement pre = con.prepareStatement(sql);
        pre.setString(1,username);
        pre.setString(2,password);
        ResultSet resultSet = pre.executeQuery();
        User user = null;
        if(resultSet.next()){
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setGender(resultSet.getString("gender"));
            user.setBirthDate(resultSet.getDate("birthdate"));
        }
        System.out.println(user);
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        String sql = "select * from usertable where username=?";
        PreparedStatement pre = con.prepareStatement(sql);
        pre.setString(1,username);
        ResultSet resultSet = pre.executeQuery();
        User user = new User();
        List<User> list = new ArrayList<>();
        while(resultSet.next()){
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setGender(resultSet.getString("gender"));
            user.setBirthDate(resultSet.getDate("birthdate"));
            list.add(user);
        }
        return list;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        String sql = "select * from usertable where password=?";
        PreparedStatement pre = con.prepareStatement(sql);
        pre.setString(1,password);
        ResultSet resultSet = pre.executeQuery();
        User user = new User();
        List<User> list = new ArrayList<>();
        while(resultSet.next()){
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setGender(resultSet.getString("gender"));
            user.setBirthDate(resultSet.getDate("birthdate"));
            list.add(user);
        }
        return list;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        String sql = "select * from usertable where email=?";
        PreparedStatement pre = con.prepareStatement(sql);
        pre.setString(1,email);
        ResultSet resultSet = pre.executeQuery();
        User user = new User();
        List<User> list = new ArrayList<>();
        while(resultSet.next()){
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setGender(resultSet.getString("gender"));
            user.setBirthDate(resultSet.getDate("birthdate"));
            list.add(user);
        }
        return list;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        String sql = "select * from usertable where gender=?";
        PreparedStatement pre = con.prepareStatement(sql);
        pre.setString(1,gender);
        ResultSet resultSet = pre.executeQuery();
        User user = new User();
        List<User> list = new ArrayList<>();
        while(resultSet.next()){
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setGender(resultSet.getString("gender"));
            user.setBirthDate(resultSet.getDate("birthdate"));
            list.add(user);
        }
        return list;
    }

    @Override
    public List<User> findByBirthday(Connection con, Date birthDate) throws SQLException {
        String sql = "select * from usertable where birthdate=?";
        PreparedStatement pre = con.prepareStatement(sql);
        pre.setDate(1,(java.sql.Date) birthDate);
        ResultSet resultSet = pre.executeQuery();
        User user = new User();
        List<User> list = new ArrayList<>();
        while(resultSet.next()){
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setGender(resultSet.getString("gender"));
            user.setBirthDate(resultSet.getDate("birthdate"));
            list.add(user);
        }
        return list;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        String sql = "select * from usertable";
        PreparedStatement pre = con.prepareStatement(sql);
        ResultSet resultSet = pre.executeQuery();
        User user = new User();
        List<User> list = new ArrayList<>();
        while(resultSet.next()){
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setEmail(resultSet.getString("email"));
            user.setGender(resultSet.getString("gender"));
            user.setBirthDate(resultSet.getDate("birthdate"));
            list.add(user);
        }
        return list;
    }
}
