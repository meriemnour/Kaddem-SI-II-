package tn.spring.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DetailEquipe")
public class DetailEquipe  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="IdEquipe")
    private int IdEquipe;
    @Column(nullable = false)
    private int salle;
    @Column(nullable = false)
    private String thematique;
    /*@OneToOne(mappedBy = "detailEquipe")
    private Equipe equipe;*/
    @OneToOne(mappedBy = "detailEquipe1")
    @JsonIgnore
    private  Equipe equipe;
}
