package org.dev._2024_09_16_web_servlet.dao.Implement;

import org.dev._2024_09_16_web_servlet.configs.DBconnectionMySQL;
import org.dev._2024_09_16_web_servlet.dao.IUserDao;
import org.dev._2024_09_16_web_servlet.models.Usermodel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImplement extends DBconnectionMySQL implements IUserDao {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    @Override
    public List<Usermodel> getUsers() {
        String sql = "SELECT * FROM users";
        List<Usermodel> users = new ArrayList<>();

        try {
            connection = DBconnectionMySQL.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                users.add(new Usermodel(resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getString("fullname"),
                        resultSet.getString("image"),
                        resultSet.getString("phone"),
                        resultSet.getInt("roleid"),
                        resultSet.getDate("createdate")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đảm bảo đóng các tài nguyên
            closeResources();
        }
        return users;
    }

    @Override
    public Usermodel findById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        Usermodel user = null;

        try {
            connection = DBconnectionMySQL.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new Usermodel();
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setId(resultSet.getInt("id"));
                user.setFullname(resultSet.getString("fullname"));
                user.setImage(resultSet.getString("image"));
                user.setPhone(resultSet.getString("phone"));
                user.setRoleid(resultSet.getInt("roleid"));
                user.setCreatedate(resultSet.getDate("createdate"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error finding user by id", e);
        } finally {
            closeResources();
        }
        return user;
    }

    @Override
    public Usermodel findByEmail(String email) {
        return null;
    }

    @Override
    public List<Usermodel> findByRoleId(int roleId) {
        String sql = "SELECT * FROM users WHERE roleid = ?";
        List<Usermodel> users = new ArrayList<>();

        try {
            connection = DBconnectionMySQL.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, roleId);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                users.add(new Usermodel(resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getString("fullname"),
                        resultSet.getString("image"),
                        resultSet.getString("phone"),
                        resultSet.getInt("roleid"),
                        resultSet.getDate("createdate")));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error finding user by role id", e);
        } finally {
            closeResources();
        }
        return users;
    }


    @Override
    public Usermodel findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        Usermodel user = null;

        try {
            connection = DBconnectionMySQL.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new Usermodel();
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setId(resultSet.getInt("id"));
                user.setFullname(resultSet.getString("fullname"));
                user.setImage(resultSet.getString("image"));
                user.setPhone(resultSet.getString("phone"));
                user.setRoleid(resultSet.getInt("roleid"));
                user.setCreatedate(resultSet.getDate("createdate"));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error finding user by username", e);
        } finally {
            closeResources();
        }
        return user;
    }

    @Override
    public Usermodel get(String username) {
        return findByUsername(username);
    }

    @Override
    public void insert(Usermodel user) {
        String sql = "INSERT INTO users (id, username, password, email, fullname, image, phone, roleid, createdate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            connection = DBconnectionMySQL.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getFullname());
            preparedStatement.setString(6, user.getImage());
            preparedStatement.setString(7, user.getPhone());
            preparedStatement.setInt(8, user.getRoleid());
            preparedStatement.setDate(9, user.getCreatedate());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error inserting user", e);
        } finally {
            closeResources();
        }
    }

    @Override
    public boolean checkExistUsername(String username) throws SQLException {
        String query = "SELECT 1 FROM users WHERE username = ?";
        connection = DBconnectionMySQL.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean checkExistEmail(String email) throws SQLException {
        String query = "SELECT 1 FROM users WHERE email = ?";
        connection = DBconnectionMySQL.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean changePassword(String email, String newEncodedPassword) throws SQLException {
        String sql = "UPDATE users SET password = ? WHERE email = ?";
        connection = DBconnectionMySQL.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, newEncodedPassword);
            ps.setString(2, email);
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException exception) {
            return false;
        }
    }

    @Override
    public boolean checkExistPhone(String phone) {
        return false;
    }

    // Hàm để đóng tài nguyên
    private void closeResources() {
        try {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
