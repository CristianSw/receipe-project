package receipe.receipeproject.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;


import javax.persistence.*;
import java.math.BigDecimal;
@Data
@EqualsAndHashCode(exclude = {"recipes"})
@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private BigDecimal amount;

   @ManyToOne
    private Recipes recipes;
   @OneToOne(fetch = FetchType.EAGER)
   private UnitOfMeasure uom;

   public Ingredient(){}

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom, Recipes recipes) {
        this.description = description;
        this.amount = amount;
        this.uom = uom;
        this.recipes = recipes;
    }
}
