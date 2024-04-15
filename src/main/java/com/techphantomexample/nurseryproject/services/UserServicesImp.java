package com.techphantomexample.nurseryproject.services;
import com.techphantomexample.nurseryproject.model.User;
import com.techphantomexample.nurseryproject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServicesImp implements UserService
{

    UserRepository userRepository;

    public UserServicesImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public String createUser(User user) {
        String userEmail = user.getUserEmail();
        String userPassword = user.getUserPassword();

        if (userEmail != null && existsByEmail(userEmail)) {
            return "User with provided Email ID exists";
        }

        if (!isValidPassword(userPassword)) {
            return "Password must be at least 8 characters long, contain at least one uppercase letter, and at least one digit";
        }

        userRepository.save(user);
        return "User Created successfully";
    }

    private boolean existsByEmail(String userEmail) {
        return userRepository.existsByUserEmail(userEmail);
    }

    private boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        return password.matches("^(?=.*[A-Z])(?=.*\\d).+$");
    }

    @Override
    public boolean updateUser(int userId, User newUserDetails) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();

            existingUser.setUserFullName(newUserDetails.getUserFullName());
            existingUser.setUserEmail(newUserDetails.getUserEmail());
            existingUser.setUserPassword(newUserDetails.getUserPassword());
            existingUser.setUserRole(newUserDetails.getUserRole());


            userRepository.save(existingUser);

            return true;
        } else {

            return false;
        }
    }

    @Override
    public boolean deleteUser(int userId) {
        if (userRepository.existsById(userId))
        {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }


    @Override
    public User getUser(int userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
