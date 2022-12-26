package hiber.dao;

import hiber.model.*;

import java.util.List;

public interface UserDao {
    void add(User user, Car car);

    List<User> listUsers();

    User getUser(long id);

    User getUserByCar(String model, int series);

}