package dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;

import dao.CrudUtil;
import dao.custom.AdminDao;
import entity.AdminEntity;

public class AdminDaoIMPL implements AdminDao {

    @Override
    public boolean save(AdminEntity t) throws Exception {
        return false;
    }

    @Override
    public boolean update(AdminEntity t) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return false;
    }

    @Override
    public AdminEntity searchById(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM admin WHERE admin_id = ?", id);
        if (rst.next()) {
            return new AdminEntity(
                    rst.getString("admin_id"),
                    rst.getString("title"),
                    rst.getString("full_name"),
                    rst.getString("dob"),
                    rst.getString("contact"),
                    rst.getString("email"),
                    rst.getString("password"),
                    rst.getString("post"));       
        }
        return null;
    }

    @Override
    public ArrayList<AdminEntity> getAll() throws Exception {
        return null;
    }

}
