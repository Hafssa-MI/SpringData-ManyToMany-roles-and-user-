package net.hafssa.jpa_springdata_manytomany.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Entity
@Data @NoArgsConstructor
@AllArgsConstructor

public class Role {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length=20, unique=true)
    private String desc;
    @ManyToMany(fetch = FetchType.EAGER)
    // qd on a une association many to many on a la creation dune table dassociation , table de jointure
    // si on choisit pas le nom de la table il va choisir par defait comme celle ci , on spécifie aussi les noms des cles etrangers
    //@JoinTable(name="USERS_ROLES",)
    private List<User> users=new ArrayList<>();
}
