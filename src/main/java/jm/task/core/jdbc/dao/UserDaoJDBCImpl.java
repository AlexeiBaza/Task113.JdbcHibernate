package jm.task.core.jdbc.dao;
import jm.task.core.jdbc.model.User;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//public class UserDaoJDBCImpl implements UserDao {
//    public UserDaoJDBCImpl() {
//    }
//
//    public List<User> getAllUsers() {
//        List<User> list = new ArrayList<>();
//        try {
//            Statement statement = Util.getConnection().createStatement();
//            String SQL = "SELECT * FROM usersTable";
//            ResultSet resultSet = statement.executeQuery(SQL);
//            while (resultSet.next()) {
//                User user = new User();
//                user.setId(resultSet.getLong("id"));
//                user.setName(resultSet.getString("name"));
//                user.setLastName(resultSet.getString("lastName"));
//                user.setAge(resultSet.getByte("age"));
//                list.add(user);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    public void saveUser(String name, String lastName, byte age) {
//        try {
//            PreparedStatement preparedStatement = Util.getConnection().prepareStatement("INSERT INTO usersTable (name, lastName, age) VALUES(?, ?, ?)");
//            preparedStatement.setString(1, name);
//            preparedStatement.setString(2, lastName);
//            preparedStatement.setInt(3, age);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        System.out.println("User с именем – " + name + " добавлен в базу данных");
//    }
//
//    public void createUsersTable() {
//        try {
//            Statement statement = Util.getConnection().createStatement();
//            String SQL = "CREATE TABLE usersTable (id SMALLINT, " +
//                    "name VARCHAR(50) NOT NULL, " +
//                    "lastName VARCHAR(50) NOT NULL, " +
//                    "age SMALLINT NOT NULL );";
//            statement.executeUpdate(SQL);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void dropUsersTable() {
//        try {
//            Statement statement = Util.getConnection().createStatement();
//            String SQL = "DROP TABLE usersTable";
//            statement.executeUpdate(SQL);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Таблица удалена");
//    }
//
//    public void removeUserById(long id) {
//        try {
//            PreparedStatement preparedStatement = Util.getConnection().prepareStatement("DELETE FROM usersTable WHERE id = ?");
//            preparedStatement.setLong(1, id);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        System.out.println("User с id – " + id + " удален из базы данных");
//    }
//
//    public void cleanUsersTable() {
//        try {
//            Statement statement = Util.getConnection().createStatement();
//            String SQL = "DELETE FROM usersTable";
//            statement.executeUpdate(SQL);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Таблица очищена");
//    }
//}
