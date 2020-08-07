package receipe.receipeproject.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import receipe.receipeproject.domain.*;
import receipe.receipeproject.repositories.CategoryRepository;
import receipe.receipeproject.repositories.RecipeRepository;
import receipe.receipeproject.repositories.UnitOfMeasureRepository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Slf4j
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        log.debug("I am in Repository constructor");
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.debug("I am in onApplicationEvent method");
        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipes> getRecipes() {
        log.debug("Enter in getRecipes method");
        List<Recipes> recipes = new ArrayList<>(2);
//        Get UOM's
        log.debug("Start verifying UOM's");
        Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");
        if (!eachUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }
        Optional<UnitOfMeasure> tableSpoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");
        if (!tableSpoonUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }
        Optional<UnitOfMeasure> teaSpoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        if (!teaSpoonUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }
        Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("Dash");
        if (!dashUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }
        Optional<UnitOfMeasure> pintUomOptional = unitOfMeasureRepository.findByDescription("Pint");
        if (!pintUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }
        Optional<UnitOfMeasure> cupUomOptional = unitOfMeasureRepository.findByDescription("Cup");
        if (!cupUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }
        Optional<UnitOfMeasure> ounceUomOptional = unitOfMeasureRepository.findByDescription("Ounce");
        if (!ounceUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not found");
        }
        log.debug("UOM's verification finished successfully ");

        //get optionals
        log.debug("Getting optionals for UOM's");
        UnitOfMeasure each = eachUomOptional.get();
        UnitOfMeasure tablespoon = tableSpoonUomOptional.get();
        UnitOfMeasure teaspoon = teaSpoonUomOptional.get();
        UnitOfMeasure dash = dashUomOptional.get();
        UnitOfMeasure pint = pintUomOptional.get();
        UnitOfMeasure cup = cupUomOptional.get();
        log.debug("Optionals for UOM's was get");
        //get categories
        log.debug("Start verifying categories");
        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");
        if (!americanCategoryOptional.isPresent()) {
            throw new RuntimeException("An expected category not found");
        }
        Optional<Category> italianCategoryOptional = categoryRepository.findByDescription("Italian");
        if (!italianCategoryOptional.isPresent()) {
            throw new RuntimeException("An expected category not found");
        }
        Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");
        if (!mexicanCategoryOptional.isPresent()) {
            throw new RuntimeException("An expected category not found");
        }
        Optional<Category> moldavianCategoryOptional = categoryRepository.findByDescription("Moldavian");
        if (!moldavianCategoryOptional.isPresent()) {
            throw new RuntimeException("An expected category not found");
        }
        Optional<Category> fastFoodCategoryOptional = categoryRepository.findByDescription("Fast Food");
        if (!fastFoodCategoryOptional.isPresent()) {
            throw new RuntimeException("An expected category not found");
        }
        log.debug("Verifying categories finished successfully");
//        Get Optionals for category
        log.debug("Getting optionals for categories");
        Category american = americanCategoryOptional.get();
        Category italian = italianCategoryOptional.get();
        Category mexican = mexicanCategoryOptional.get();
        Category moldavian = moldavianCategoryOptional.get();
        Category fastFood = fastFoodCategoryOptional.get();
        log.debug("Optionals for categories was get");

//        Yummy Guac

        log.debug("Start creating guac recipe");
        Recipes guacRecipes = new Recipes();
        guacRecipes.setDescription("Perfect Guacamole");
        guacRecipes.setPrepTime(10);
        guacRecipes.setCockTime(0);
        guacRecipes.setDifficulty(Difficulty.EASY);
        guacRecipes.setDirections("1 Cut the avocado, remove flesh: Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon." +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving." +
                "\n" +
                "4 Serve: Serve immediately, or if making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve." +
                "\n" +
                "\n" +
                "Read More on https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        log.debug("Start creting Notes for guac");
        Notes guacNotes = new Notes();
        guacNotes.setRecipesNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados." +
                "\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great." +
                "\n" +
                "he simplest version of guacamole is just mashed avocados with salt. Don’t let the lack of availability of other ingredients stop you from making guacamole.");
        guacNotes.setRecipes(guacRecipes);
        log.debug("Assign guac note to guac recipe finished successfully");
        guacRecipes.setNotes(guacNotes);
        log.debug("Assign guac recipe to guac notes finished successfully");
        log.debug("Start adding guac Ingredients");
        guacRecipes.getIngredients().add(new Ingredient("ripe avocados", new BigDecimal(2), each, guacRecipes));
        guacRecipes.getIngredients().add(new Ingredient("Kosher salt", new BigDecimal(".5"), teaspoon, guacRecipes));
        guacRecipes.getIngredients().add(new Ingredient("fresh lime juice or lemon juice", new BigDecimal(1), tablespoon, guacRecipes));
        guacRecipes.getIngredients().add(new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(2), tablespoon, guacRecipes));
        guacRecipes.getIngredients().add(new Ingredient("serrano chiles, stems and seeds removed, minced", new BigDecimal(2), each, guacRecipes));
        guacRecipes.getIngredients().add(new Ingredient("cilantro (leaves and tender stems), finely chopped", new BigDecimal(2), tablespoon, guacRecipes));
        guacRecipes.getIngredients().add(new Ingredient("fresh grated black pepper", new BigDecimal(1), dash, guacRecipes));
        guacRecipes.getIngredients().add(new Ingredient("ripe tomato, seeds and pulp removed, chopped", new BigDecimal(2), each, guacRecipes));
        log.debug("Ingredients was added successfully");
        log.debug("Start assigning categories for guac");
        guacRecipes.getCategories().add(american);
        guacRecipes.getCategories().add(italian);
        guacRecipes.getCategories().add(mexican);
        guacRecipes.getCategories().add(moldavian);
        log.debug("Categories for guac was assigned successfully");
        log.debug("Try to set url");
        guacRecipes.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        log.debug("Try to set servings");
        guacRecipes.setServings(4);
        log.debug("Try to set source");
        guacRecipes.setSource("Simply Recipes");
        log.debug("Try to save guac recipe to recipes list");
        recipes.add(guacRecipes);
        log.debug("Guac recipe successfully saved to recipes list");

//        chicken grill
        log.debug("Start creating chickenGrill recipe");
        Recipes chickenGrill = new Recipes();
        chickenGrill.setDescription("Spicy Grilled Chicken Tacos");
        chickenGrill.setPrepTime(20);
        chickenGrill.setCockTime(9);
        chickenGrill.setDifficulty(Difficulty.MEDIUM);
        chickenGrill.setDirections("Prepare a gas or charcoal grill for medium-high, direct heat." +
                "\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings." +
                "\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes." +
                "\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges." +
                "\n" +
                "\n" +
                "Read more on https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        log.debug("Creating Notes for chickenGrill");
        Notes grillNotes = new Notes();
        grillNotes.setRecipesNotes("The ancho chiles I use in the marinade are named for their wide shape. They are large, have a deep reddish brown color when dried, and are mild in flavor with just a hint of heat. You can find ancho chile powder at any markets that sell Mexican ingredients, or online.\n" +
                "\n" +
                "I like to put all the toppings in little bowls on a big platter at the center of the table: avocados, radishes, tomatoes, red onions, wedges of lime, and a sour cream sauce. I add arugula, as well – this green isn’t traditional for tacos, but we always seem to have some in the fridge and I think it adds a nice green crunch to the tacos.\n" +
                "\n" +
                "Everyone can grab a warm tortilla from the pile and make their own tacos just they way they like them.\n" +
                "\n" +
                "You could also easily double or even triple this recipe for a larger party. A taco and a cold beer on a warm day? Now that’s living!");

        grillNotes.setRecipes(chickenGrill);
        log.debug("Assign to grillNotes chickenGrill recipe was successful");
        chickenGrill.setNotes(grillNotes);
        log.debug("Assigning to chickenGrill recipe grillNotes was successful");
        log.debug("Start adding ingredients to chickenGrill recipe");
        chickenGrill.getIngredients().add(new Ingredient("ancho chili powder", new BigDecimal(2), tablespoon, chickenGrill));
        chickenGrill.getIngredients().add(new Ingredient("dried oregano", new BigDecimal(1), teaspoon, chickenGrill));
        chickenGrill.getIngredients().add(new Ingredient("dried cumin", new BigDecimal(1), teaspoon, chickenGrill));
        chickenGrill.getIngredients().add(new Ingredient("sugar", new BigDecimal(1), teaspoon, chickenGrill));
        chickenGrill.getIngredients().add(new Ingredient("salt", new BigDecimal(2), teaspoon, chickenGrill));
        chickenGrill.getIngredients().add(new Ingredient("clove garlic, finely chopped", new BigDecimal(1), each, chickenGrill));
        chickenGrill.getIngredients().add(new Ingredient("finely grated orange zest", new BigDecimal(1), tablespoon, chickenGrill));
        chickenGrill.getIngredients().add(new Ingredient("fresh-squeezed orange juice", new BigDecimal(3), tablespoon, chickenGrill));
        chickenGrill.getIngredients().add(new Ingredient("olive oil", new BigDecimal(2), tablespoon, chickenGrill));
        chickenGrill.getIngredients().add(new Ingredient("boneless chicken thighs (1 1/4 pounds)", new BigDecimal(4), tablespoon, chickenGrill));
        chickenGrill.getIngredients().add(new Ingredient("small corn tortillas", new BigDecimal(8), each, chickenGrill));
        chickenGrill.getIngredients().add(new Ingredient("packed baby arugula (3 ounces)", new BigDecimal(3), cup, chickenGrill));
        chickenGrill.getIngredients().add(new Ingredient("medium ripe avocados, sliced", new BigDecimal(2), each, chickenGrill));
        chickenGrill.getIngredients().add(new Ingredient("radishes, thinly sliced", new BigDecimal(4), each, chickenGrill));
        chickenGrill.getIngredients().add(new Ingredient("cherry tomatoes, halved", new BigDecimal(2), pint, chickenGrill));
        chickenGrill.getIngredients().add(new Ingredient("red onion, thinly sliced", new BigDecimal(1), each, chickenGrill));
        chickenGrill.getIngredients().add(new Ingredient("Roughly chopped cilantro", new BigDecimal(1), each, chickenGrill));
        chickenGrill.getIngredients().add(new Ingredient("sour cream thinned with 1/4 cup milk", new BigDecimal(2), cup, chickenGrill));
        chickenGrill.getIngredients().add(new Ingredient("lime, cut into wedges", new BigDecimal(1), each, chickenGrill));
        log.debug("Ingredients was added successfully to chickenGrill recipe");
        log.debug("Start assigning categories to chickenGrill recipe");
        chickenGrill.getCategories().add(american);
        chickenGrill.getCategories().add(italian);
        chickenGrill.getCategories().add(mexican);
        chickenGrill.getCategories().add(moldavian);
        log.debug("Categories was assigned successfully");
        log.debug("Try to set url");
        guacRecipes.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        log.debug("Try to set servings");
        guacRecipes.setServings(4);
        log.debug("Try to set source");
        guacRecipes.setSource("Simply Recipes");
        log.debug("Try to save chickenGrill recipe to recipes list");
        recipes.add(chickenGrill);
        log.debug("ChickenGrill recipe was successfully saved to recipes list");

        return recipes;
    }
}
