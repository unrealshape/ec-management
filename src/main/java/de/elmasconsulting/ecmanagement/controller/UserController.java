package de.elmasconsulting.ecmanagement.controller;

import de.elmasconsulting.ecmanagement.Exceptions.UserNotFoundException;
import de.elmasconsulting.ecmanagement.model.User;
import de.elmasconsulting.ecmanagement.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/user")
    public List<User> getAllUser() {
        log.info("getAllUser()");
        return userRepository.findAll();
    }

    @PostMapping("/user")
    User newUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // Single item

    @GetMapping("/user/{id}")
    User one(@PathVariable Long id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    User replaceUser(@RequestBody User user, @PathVariable Long id) {
        log.info("replaceUser()");
        return userRepository.findById(id)
                .map(users -> {
                    user.setUsername(user.getUsername());
                    user.setRollID(user.getRollID());
                    return userRepository.save(user);
                })
                .orElseGet(() -> {
                    user.setUserID(id);
                    return userRepository.save(user);
                });
    }

    @DeleteMapping("/user/{id}")
    void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
