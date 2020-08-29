package receipe.receipeproject.converters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import receipe.receipeproject.commands.CategoryCommand;
import receipe.receipeproject.domain.Category;

import static org.junit.jupiter.api.Assertions.*;

class CategoryCommandToCategoryTest {

    public static final Long ID_VALUE = 1L;
    public static final String DESCRIPTION = "description";
    CategoryCommandToCategory converter;

    @BeforeEach
    void setUp() {
        converter = new CategoryCommandToCategory();
    }

    @Test
    void testNullObject() {
        assertNull(converter.convert(null));
    }

    @Test
    void emptyObject() {
        assertNotNull(converter.convert(new CategoryCommand()));
    }

    @Test
    void convert() {
        //given
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(ID_VALUE);
        categoryCommand.setDescription(DESCRIPTION);

        //when
        Category category = converter.convert(categoryCommand);

        //then
        assertEquals(categoryCommand.getId(), ID_VALUE);
        assertEquals(categoryCommand.getDescription(), DESCRIPTION);
    }
}