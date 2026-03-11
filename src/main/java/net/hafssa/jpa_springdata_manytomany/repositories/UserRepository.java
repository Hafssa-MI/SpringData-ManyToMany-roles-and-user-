package net.hafssa.jpa_springdata_manytomany.repositories;

import net.hafssa.jpa_springdata_manytomany.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
//DAO
public interface UserRepository extends JpaRepository<User,String> {
    User findByUsername(String userName);
}
