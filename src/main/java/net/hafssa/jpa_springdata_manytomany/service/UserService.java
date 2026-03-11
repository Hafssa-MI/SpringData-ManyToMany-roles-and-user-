package net.hafssa.jpa_springdata_manytomany.service;

import net.hafssa.jpa_springdata_manytomany.entities.Role;
import net.hafssa.jpa_springdata_manytomany.entities.User;

public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String username);
    Role findRoleByRoleName(String roleName);
    // pour ca on doit avoir un unique username et unique role , on definit ca dans le mapping dans les entite
    void addRoleToUser(String username, String roleName);
    User authenticate(String userName, String password);
}
