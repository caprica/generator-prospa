package <%= packageName %>.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import <%= packageName %>.domain.User;
import <%= packageName %>.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> user(String username) {
        return userRepository.readUser(username);
    }

    @Override
    public List<User> users() {
        return userRepository.readUsers();
    }

}
