package com.HuangZhiCheng.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : hzc
 * @date: 2021/5/14 - 05 - 14 - 18:58
 * @Description: com.HuangZhiCheng.model
 * @version: 1.0
 */
public class Category {
    private Integer categoryId;
    private String categoryName;
    private String description;
    private Boolean active;

    //property accessors

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    //methods
    public Category() {
    }

    public Category(Integer categoryId, String categoryName, String description, Boolean active) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
        this.active = active;
    }

    public static List<Category> findAllCategory(Connection con) throws SQLException {
        String sql="select * from Category";
        ArrayList<Category> list = new ArrayList<>();
        PreparedStatement pt = con.prepareStatement(sql);
        ResultSet rs = pt.executeQuery();
        while (rs.next()){
            Category c = new Category();
            c.setCategoryId(rs.getInt("categoryId"));
            c.setCategoryName(rs.getString("categoryName"));
            c.setDescription(rs.getString("description"));
            list.add(c);
        }
        return list;
    }

    public static String findByCategoryId(Connection con,int categoryId) throws SQLException {
        String sql = "select * from Category where categoryId = ?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setInt(1,categoryId);
        ResultSet rs = pt.executeQuery();
        String categoryName = null;
        while (rs.next()){
            categoryName = rs.getString("categoryName");
        }
        return categoryName;

    }


    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                ", active=" + active +
                '}';
    }
}
