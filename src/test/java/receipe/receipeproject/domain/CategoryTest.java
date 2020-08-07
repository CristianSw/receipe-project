package receipe.receipeproject.domain;

import org.junit.Before;

import static org.junit.Assert.*;

public class CategoryTest {

    Category category;

    @Before
    public void setUp(){
        category  = new Category();
    }

    @org.junit.Test
    public void getId() {
        Long idValue = 4L;
        category.setId(4L);
        assertEquals(idValue,category.getId());

    }

    @org.junit.Test
    public void getDescription() {
        String descriptionValue = "Some Description";
        category.setDescription("Some Description");
        assertEquals(descriptionValue,category.getDescription());

    }

    @org.junit.Test
    public void getRecipes() {
    }
}