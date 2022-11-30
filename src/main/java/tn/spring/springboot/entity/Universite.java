package tn.spring.springboot.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Universite")
public class Universite implements Serializable {
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int idUniv;
    @Column(nullable = false)
    private String nomUniv;
    @OneToMany
    List<Departement> departements;*/
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idUni")
    private int idUni; // Clé primaire
    private String nomUni;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Departement> departement;
}
