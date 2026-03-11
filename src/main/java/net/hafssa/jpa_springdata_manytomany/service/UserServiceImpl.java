package net.hafssa.jpa_springdata_manytomany.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import net.hafssa.jpa_springdata_manytomany.entities.Role;
import net.hafssa.jpa_springdata_manytomany.entities.User;
import net.hafssa.jpa_springdata_manytomany.repositories.RoleRepository;
import net.hafssa.jpa_springdata_manytomany.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service // pour la couche metier
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Override
    public User addNewUser(User user){
        user.setUserId(UUID.randomUUID().toString());

        return userRepository.save(user);
    };
    public Role addNewRole(Role role){
        return roleRepository.save(role);
    };
    public User findUserByUserName(String username){

        return userRepository.findByUsername(username);
    };
    public Role findRoleByRoleName(String roleName){
        return roleRepository.findByRoleName(roleName);
    }
    public void addRoleToUser(String username, String roleName){
        User user = findUserByUserName(username);
        Role role = findRoleByRoleName(roleName);
        if(user.getRoles()!=null){
            user.getRoles().add(role);
        }
    }
}
