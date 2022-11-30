package tn.spring.springboot.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Getter
@Setter
@ToString
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Contrat")
public class Contrat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Auto
    @Column(nullable = false)
    private int idContrat;
    @Column(nullable = false)
    private Date dateDebutContrat;
    @Column(nullable = false)
    private Date dateFinContrat;
    @Column(name = "archive")
    private Boolean archive;
    @Column(name = "montant")
    private int montant;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Specialite specialite;
    @ManyToOne
    private Etudiant etudiant;


}
