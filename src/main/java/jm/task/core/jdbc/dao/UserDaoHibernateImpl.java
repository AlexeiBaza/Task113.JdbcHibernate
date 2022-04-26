package jm.task.core.jdbc.dao;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.security.auth.login.Configuration;
import java.util.List;
import java.util.Queue;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {}

    @Override
    public void createUsersTable() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t1 = session.beginTransaction();
        String sql = "CREATE TABLE IF NOT EXISTS userTable " +
                "(id BIGSERIAL NOT NULL PRIMARY KEY, " +
                "name VARCHAR(50) NOT NULL, lastName VARCHAR(50) NOT NULL, " +
                "age BIGINT NOT NULL )";
        Query query = session.createSQLQuery(sql).addEntity(User.class);
        query.executeUpdate();
        t1.commit();
        session.close();
    }

    @Override
    public void dropUsersTable() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t1 = session.beginTransaction();
        String sql = "DROP TABLE userTable";
        Query query = session.createSQLQuery(sql).addEntity(User.class);
        query.executeUpdate();
        t1.commit();
        session.close();//закрытие SessionFactory
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = HibernateUtil.getSessionFactory().openSession();//создание сессии
        Transaction tx1 = session.getTransaction();

        User user1 = new User();//id не указываем т.к он сгенериться автоматически в БД и присвоится в поле
        user1.setName(name);
        user1.setLastName(lastName);
        user1.setAge(age);

        session.save(user1);//фиксирует изменения в объекте

        tx1.commit();
        session.close();//закрыть сессию

//        session.beginTransaction().begin();//открыть транзакцию т.к операция обновления и это нужно делать в транзакции
//
//
//        session.getTransaction().commit();//commit - все изменения, которые были произведены внутри транзакции, сохранены в БД
    }

    @Override
    public void removeUserById(long id) {
        User user;
        Session session = HibernateUtil.getSessionFactory().openSession();
        user = session.load(User.class, id);
        session.delete(user);
        session.close();
    }

    @Override
    public List<User> getAllUsers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<User> list = session.createSQLQuery("SELECT * FROM userTable").list();
        return list;
    }

    @Override
    public void cleanUsersTable() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.clear();
        session.close();


//        Transaction t1 = session.beginTransaction();
//        String sql = "DELETE FROM userTable";
//        Query query = session.createSQLQuery(sql).addEntity(User.class);
//        query.executeUpdate();
//        t1.commit();
//        session.close();
    }
}
