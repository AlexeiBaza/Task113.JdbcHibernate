package jm.task.core.jdbc;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        userServiceImpl.dropUsersTable();

        userServiceImpl.createUsersTable();
        userServiceImpl.saveUser("Name1", "LastName1", (byte) 10);


//        userServiceImpl.cleanUsersTable();

//        userServiceImpl.saveUser("Name2", "LastName2", (byte) 20);
//        userServiceImpl.saveUser("Name3", "LastName3", (byte) 30);
//        userServiceImpl.saveUser("Name4", "LastName4", (byte) 40);
//        userServiceImpl.removeUserById(1);
    }
}
