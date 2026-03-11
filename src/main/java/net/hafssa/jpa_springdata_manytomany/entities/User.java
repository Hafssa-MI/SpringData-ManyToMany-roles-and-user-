package net.hafssa.jpa_springdata_manytomany.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
// pas nécessaire juste si on name une table (classe) avec un mot clé : ex "Group" ,  attribut :"desc"
@Table(name="USERS")
@Data @NoArgsConstructor
@AllArgsConstructor

public class User {
    @Id
    private String userId;
    @Column(name="USER_NAME",unique = true, length = 20)
    private String username;
    private String password;
    // EAGER pour qu'on on appele un user on appelle la liste de ses roles
    @ManyToMany(mappedBy = "users", fetch= FetchType.EAGER)
    // Qd on utilise EAGER on doit initialiser un ArrayList pour éviter le NullPointerException
    private List<Role> roles=new ArrayList<>();
}
