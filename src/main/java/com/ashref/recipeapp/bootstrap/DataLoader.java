package com.ashref.recipeapp.bootstrap;

import com.ashref.recipeapp.entities.*;
import com.ashref.recipeapp.enums.Difficulty;
import com.ashref.recipeapp.repositories.CategoryRepository;
import com.ashref.recipeapp.repositories.RecipeRepository;
import com.ashref.recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final CategoryRepository categoryRepository;

    public DataLoader(RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository, CategoryRepository categoryRepository) {
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadData();
    }

    private void loadData() {
        // Units Of Measure
        UnitOfMeasure teaspoon = unitOfMeasureRepository.findByDescription("Teaspoon").get();
        UnitOfMeasure tablespoon = unitOfMeasureRepository.findByDescription("Tablespoon").get();
        UnitOfMeasure cup = unitOfMeasureRepository.findByDescription("Cup").get();
        UnitOfMeasure pinch = unitOfMeasureRepository.findByDescription("Pinch").get();
        UnitOfMeasure ounce = unitOfMeasureRepository.findByDescription("Ounce").get();
        UnitOfMeasure clove = unitOfMeasureRepository.findByDescription("Clove").get();
        UnitOfMeasure pound = unitOfMeasureRepository.findByDescription("Pound").get();
        UnitOfMeasure corn = unitOfMeasureRepository.findByDescription("Corn").get();
        UnitOfMeasure pint = unitOfMeasureRepository.findByDescription("Pint").get();
        UnitOfMeasure dash = unitOfMeasureRepository.findByDescription("Dash").get();
        UnitOfMeasure each = unitOfMeasureRepository.findByDescription("Each").get();

        // Categories
        Category tunisian = categoryRepository.findByName("Tunisian").get();
        Category american = categoryRepository.findByName("American").get();
        Category italian = categoryRepository.findByName("Italian").get();
        Category mexican = categoryRepository.findByName("Mexican").get();
        Category fastFood = categoryRepository.findByName("Fast Food").get();

        // Recipes
        Set<Recipe> recipes = new HashSet<>();

        Recipe guacamole = new Recipe();
        guacamole.setName("Perfect Guacamole");
        guacamole.setPrepTime(10);
        guacamole.setCookTime(0);
        guacamole.setDifficulty(Difficulty.EASY);
        guacamole.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
                "\n" +
                "\n" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                "\n" +
                "\n" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "\n" +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                "\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.");

        guacamole.setNote(new Note("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries (see our Strawberry Guacamole).\n" +
                "\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
                "\n" +
                "For a deviled egg version with guacamole, try our Guacamole Deviled Eggs!"));

        guacamole.addIngredient(new Ingredient("ripe avocados", new BigDecimal(2), each));
        guacamole.addIngredient(new Ingredient("Kosher salt", new BigDecimal(".5"), teaspoon));
        guacamole.addIngredient(new Ingredient("fresh lime juice or lemon juice", new BigDecimal(2), tablespoon));
        guacamole.addIngredient(new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(2), tablespoon));
        guacamole.addIngredient(new Ingredient("serrano chiles, stems and seeds removed, minced", new BigDecimal(2), each));
        guacamole.addIngredient(new Ingredient("Cilantro", new BigDecimal(2), tablespoon));
        guacamole.addIngredient(new Ingredient("freshly grated black pepper", new BigDecimal(2), dash));
        guacamole.addIngredient(new Ingredient("ripe tomato, seeds and pulp removed, chopped", new BigDecimal(".5"), each));

        guacamole.getCategories().add(american);
        guacamole.getCategories().add(mexican);

        guacamole.setUrl("http://www.simplyrecipes.com/recipes/perfect_guacamole/");
        guacamole.setServings(4);
        guacamole.setSource("Simply Recipes");

        recipes.add(guacamole);

        Recipe tacos = new Recipe();
        tacos.setName("Spicy Grilled Chicken Taco");
        tacos.setPrepTime(20);
        tacos.setCookTime(9);
        tacos.setDifficulty(Difficulty.MODERATE);
        tacos.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "\n" +
                "Spicy Grilled Chicken Tacos\n" +
                "\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.");

        tacos.setNote(new Note("We have a family motto and it is this: Everything goes better in a tortilla.\n" +
                "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.\n" +
                "Today’s tacos are more purposeful – a deliberate meal instead of a secretive midnight snack!\n" +
                "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings.\n" +
                "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvu7Q0MJ"));

        tacos.addIngredient(new Ingredient("Ancho Chili Powder", new BigDecimal(2), tablespoon));
        tacos.addIngredient(new Ingredient("Dried Oregano", new BigDecimal(1), teaspoon));
        tacos.addIngredient(new Ingredient("Dried Cumin", new BigDecimal(1), teaspoon));
        tacos.addIngredient(new Ingredient("Sugar", new BigDecimal(1), teaspoon));
        tacos.addIngredient(new Ingredient("Salt", new BigDecimal(".5"), teaspoon));
        tacos.addIngredient(new Ingredient("Clove of Garlic, Choppedr", new BigDecimal(1), each));
        tacos.addIngredient(new Ingredient("finely grated orange zestr", new BigDecimal(1), tablespoon));
        tacos.addIngredient(new Ingredient("fresh-squeezed orange juice", new BigDecimal(3), tablespoon));
        tacos.addIngredient(new Ingredient("Olive Oil", new BigDecimal(2), tablespoon));
        tacos.addIngredient(new Ingredient("boneless chicken thighs", new BigDecimal(4), tablespoon));
        tacos.addIngredient(new Ingredient("small corn tortillasr", new BigDecimal(8), each));
        tacos.addIngredient(new Ingredient("packed baby arugula", new BigDecimal(3), cup));
        tacos.addIngredient(new Ingredient("medium ripe avocados, slic", new BigDecimal(2), each));
        tacos.addIngredient(new Ingredient("radishes, thinly sliced", new BigDecimal(4), each));
        tacos.addIngredient(new Ingredient("cherry tomatoes, halved", new BigDecimal(".5"), pint));
        tacos.addIngredient(new Ingredient("red onion, thinly sliced", new BigDecimal(".25"), each));
        tacos.addIngredient(new Ingredient("Roughly chopped cilantro", new BigDecimal(4), each));
        tacos.addIngredient(new Ingredient("cup sour cream thinned with 1/4 cup milk", new BigDecimal(4), cup));
        tacos.addIngredient(new Ingredient("lime, cut into wedges", new BigDecimal(4), each));

        tacos.getCategories().add(american);
        tacos.getCategories().add(mexican);

        tacos.setUrl("http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        tacos.setServings(4);
        tacos.setSource("Simply Recipes");

        recipes.add(tacos);

        recipeRepository.saveAll(recipes);
        System.out.println("Created Recipes ...");
    }
}
