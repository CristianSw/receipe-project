package receipe.receipeproject.domain;

import receipe.receipeproject.domain.Recipes;

import javax.persistence.*;

@Entity
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Recipes recipes;
    @Lob
    private String recipesNotes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recipes getRecipes() {
        return recipes;
    }

    public void setRecipes(Recipes recipes) {
        this.recipes = recipes;
    }

    public String getRecipesNotes() {
        return recipesNotes;
    }

    public void setRecipesNotes(String recipesNotes) {
        this.recipesNotes = recipesNotes;
    }
}
