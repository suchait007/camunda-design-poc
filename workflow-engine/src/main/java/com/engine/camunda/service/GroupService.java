package com.engine.camunda.service;


import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.identity.Group;
import org.springframework.stereotype.Service;

@Service
public class GroupService {

    private final IdentityService identityService;

    public GroupService(IdentityService identityService) {
        this.identityService = identityService;
    }

    /**
     * Create a new group in Camunda.
     *
     * @param groupId   The unique identifier for the group.
     * @param groupName The display name of the group.
     */
    public void createGroup(String groupId, String groupName) {
        Group group = identityService.newGroup(groupId);
        group.setName(groupName);
        group.setType("WORKFLOW"); // Group type can be "WORKFLOW", "SECURITY", etc.
        identityService.saveGroup(group);
    }

    /**
     * Add a user to a group.
     *
     * @param userId  The ID of the user.
     * @param groupId The ID of the group.
     */
    public void addUserToGroup(String userId, String groupId) {
        identityService.createMembership(userId, groupId);
    }

    /**
     * Remove a user from a group.
     *
     * @param userId  The ID of the user.
     * @param groupId The ID of the group.
     */
    public void removeUserFromGroup(String userId, String groupId) {
        identityService.deleteMembership(userId, groupId);
    }
}
