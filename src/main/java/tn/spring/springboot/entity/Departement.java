package tn.spring.springboot.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Departement")
public class Departement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int idDepart;
    @Column(nullable = false)
    private String nomDepart;
   @OneToMany(mappedBy = "departement")
    List<Etudiant> etudiants;

    /*@Temporal(TemporalType.DATE)
    Date publicationDate;*/
}
