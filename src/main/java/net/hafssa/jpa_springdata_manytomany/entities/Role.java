package net.hafssa.jpa_springdata_manytomany.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@Entity
@Data @NoArgsConstructor
@AllArgsConstructor

public class Role {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length=20, unique=true)
    private String roleName;
    @ManyToMany(fetch = FetchType.EAGER)
    // qd on a une association many to many on a la creation dune table dassociation , table de jointure
    // si on choisit pas le nom de la table il va choisir par defait comme celle ci , on spécifie aussi les noms des cles etrangers
    //@JoinTable(name="USERS_ROLES",)
    @ToString.Exclude // pour ne pas entrer dans une boucle infifni lore de laffichage
    //pour  mysql
    @JsonProperty (access = JsonProperty.Access.WRITE_ONLY)
    private List<User> users=new ArrayList<>();
}
