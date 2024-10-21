package com.engine.camunda.service;

import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.identity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final IdentityService identityService;

    public UserService(IdentityService identityService) {
        this.identityService = identityService;
    }

    /**
     * Create a new user in Camunda.
     *
     * @param userId    The unique identifier of the user.
     * @param firstName First name of the user.
     * @param lastName  Last name of the user.
     * @param email     Email address of the user.
     * @param password  Password for the user.
     */
    public void createUser(String userId, String firstName, String lastName, String email, String password) {
        User user = identityService.newUser(userId);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);

        identityService.saveUser(user); // Save user in Camunda
    }

    /**
     * Retrieve all users from Camunda.
     *
     * @return List of users.
     */
    public List<User> getAllUsers() {
        return identityService.createUserQuery().list();
    }

    /**
     * Retrieve a user by their ID.
     *
     * @param userId The ID of the user to retrieve.
     * @return User object.
     */
    public User getUserById(String userId) {
        return identityService.createUserQuery().userId(userId).singleResult();
    }

    /**
     * Delete a user by their ID.
     *
     * @param userId The ID of the user to delete.
     */
    public void deleteUser(String userId) {
        identityService.deleteUser(userId);
    }

    public List<User> getUsersByGroup(String groupId) {
        return identityService.createUserQuery().memberOfGroup(groupId).list();
    }
}
