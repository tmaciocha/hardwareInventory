package service;

import pl.tm.hardwareinventory.model.User;


public interface UserService {
    User findByUserName(String name);

    void saveUser(User user);
}