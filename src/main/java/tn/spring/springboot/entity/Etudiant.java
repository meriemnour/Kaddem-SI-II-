package tn.spring.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "Etudiant")
public class  Etudiant implements Serializable {
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int idEtudiant;
    @Column(nullable = false)
    private String prenomE;
    @Column(nullable = false)
    private String nomE;
    @Enumerated(EnumType.STRING)
    private Option option;
    @OneToMany(mappedBy = "etudiant")
    List<Contrat> contrats;
    @ManyToOne
    private Departement departement;
    @ManyToMany
    List<Equipe> equipes;*/
    //many to many uni wala bi +1 to many(uni) -->dima iji table association

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name="idEtudiant")
    private int idEtudiant; // Clé primaire
    @NonNull
    private String prenom;
    private String nom;
    @Enumerated(EnumType.STRING)
    private Option option;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    Departement departement;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "etudiant")
    @JsonIgnore
    private Set<Contrat> contrats;
    @ManyToMany(cascade = CascadeType.ALL)
    //@JsonIgnoreProperties
    @JsonIgnore
    private Set <Equipe> equipes;
}
