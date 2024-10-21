package com.engine.camunda.api.user;

import com.engine.camunda.service.GroupService;
import com.engine.camunda.service.UserService;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.identity.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final GroupService groupService;


    // Create a new user
    @PostMapping("/create")
    public String createUser(@RequestBody UserDTO userDTO) {
        userService.createUser(userDTO.getUserId(), userDTO.getFirstName(), userDTO.getLastName(), userDTO.getEmail(), userDTO.getPassword());
        return "User created successfully!";
    }


    @GetMapping("/get-all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Retrieve a specific user by ID
    @GetMapping("/{userId}")
    public User getUserById(@PathVariable String userId) {
        return userService.getUserById(userId);
    }

    // Delete a user by ID
    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return "User deleted successfully!";
    }

    // Create a new group
    @PostMapping("/groups")
    public String createGroup(@RequestBody GroupDTO groupDTO) {
        groupService.createGroup(groupDTO.getGroupId(), groupDTO.getGroupName());
        return "Group created successfully!";
    }

    // Add a user to a group
    @PutMapping("/groups/{groupId}/users/{userId}")
    public String addUserToGroup(@RequestBody UserGroup userGroup) {
        groupService.addUserToGroup(userGroup.getUserId(), userGroup.getGroupId());
        return "User added to group successfully!";
    }

    @GetMapping("/groups/{groupId}/users")
    public List<User> getUsersByGroup(@PathVariable("groupId") String groupId) {
        return userService.getUsersByGroup(groupId);
    }

}
