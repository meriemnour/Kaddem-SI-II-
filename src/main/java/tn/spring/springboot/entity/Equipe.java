package tn.spring.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Builder
@Table(name = "Equipe")
public class Equipe implements Serializable {
   /* @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int idEquipe;
    @Column(nullable = false)
    private String nomEquipe;
    @Enumerated(EnumType.STRING)
    private Niveau niveau;
    @ManyToMany(mappedBy = "equipes")
    List<Etudiant> etudiants;
    @OneToOne
    private DetailEquipe detailEquipe;*/

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idEquipe")
    private int idEquipe; // Clé primaire
    private String nomEquipe;
    @Enumerated(EnumType.STRING)
    private Niveau niveau;
    @OneToOne
    @JsonIgnore
    private DetailEquipe detailEquipe1;
    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "equipes")
    @JsonIgnore
    private Set<Etudiant> etudiants;
// Constructeur et accesseurs (getters) et mutateurs (setters)

}
