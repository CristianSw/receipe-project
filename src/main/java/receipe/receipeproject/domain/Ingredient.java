package receipe.receipeproject.domain;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;

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

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom,Recipes recipes) {
        this.description = description;
        this.amount = amount;
        this.uom = uom;
        this.recipes = recipes;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Recipes getRecipes() {
        return recipes;
    }

    public void setRecipes(Recipes recipes) {
        this.recipes = recipes;
    }
}
