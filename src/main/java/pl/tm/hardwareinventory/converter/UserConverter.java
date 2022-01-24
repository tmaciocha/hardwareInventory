package pl.tm.hardwareinventory.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import pl.tm.hardwareinventory.model.User;
import pl.tm.hardwareinventory.repository.UserRepository;

public class UserConverter implements Converter<String, User> {

    //  public class AuthorConverter implements Converter<String, Author> {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User convert(String source) {
        return userRepository.getById(Long.parseLong(source));
    }


}
