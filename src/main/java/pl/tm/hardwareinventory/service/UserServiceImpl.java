package pl.tm.hardwareinventory.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.tm.hardwareinventory.model.Role;
import pl.tm.hardwareinventory.model.User;
import pl.tm.hardwareinventory.repository.RoleRepository;
import pl.tm.hardwareinventory.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    @Override
    public User findByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role userRole = new Role();
        if (user.isSuperUser()) {
            userRole = roleRepository.findByName("ROLE_ADMIN");
        } else {
            userRole = roleRepository.findByName("ROLE_USER");
        }
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userRepository.save(user);
    }
}