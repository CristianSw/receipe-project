package receipe.receipeproject.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;


import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = {"recipes"})
@Entity
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Recipes recipes;
    @Lob
    private String recipesNotes;
}
