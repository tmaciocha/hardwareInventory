package pl.tm.hardwareinventory.service;

import org.springframework.stereotype.Service;
import pl.tm.hardwareinventory.model.User;

public interface UserService {
    User findByUserName(String name);

    void saveUser(User user);


}