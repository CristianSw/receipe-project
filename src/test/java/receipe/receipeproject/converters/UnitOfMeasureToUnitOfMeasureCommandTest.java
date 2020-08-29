package receipe.receipeproject.converters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import receipe.receipeproject.commands.UnitOfMeasureCommand;
import receipe.receipeproject.domain.UnitOfMeasure;

import static org.junit.jupiter.api.Assertions.*;

class UnitOfMeasureToUnitOfMeasureCommandTest {

    public static final Long ID_VALUE = 1L;
    public static final String DESCRIPTION = "DESCRIPTION";
    UnitOfMeasureToUnitOfMeasureCommand converter;

    @BeforeEach
    void setUp() {
        converter = new UnitOfMeasureToUnitOfMeasureCommand();
    }

    @Test
    void nullObject() {
        assertNull(converter.convert(null));
    }

    @Test
    void emptyObject() {
        assertNotNull(converter.convert(new UnitOfMeasure()));
    }

    @Test
    void convert() {
        //given
        UnitOfMeasure unitOfMeasure = new UnitOfMeasure();
        unitOfMeasure.setId(ID_VALUE);
        unitOfMeasure.setDescription(DESCRIPTION);
        //when
        UnitOfMeasureCommand unitOfMeasureCommand = converter.convert(unitOfMeasure);
        //then
        assertNotNull(unitOfMeasureCommand);
        assertEquals(ID_VALUE, unitOfMeasureCommand.getId());
        assertEquals(DESCRIPTION, unitOfMeasureCommand.getDescription());
    }
}