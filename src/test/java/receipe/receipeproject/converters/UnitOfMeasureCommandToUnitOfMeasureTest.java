package receipe.receipeproject.converters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import receipe.receipeproject.commands.UnitOfMeasureCommand;
import receipe.receipeproject.domain.UnitOfMeasure;

import static org.junit.jupiter.api.Assertions.*;

class UnitOfMeasureCommandToUnitOfMeasureTest {
    public static final Long ID_VALUE = 1L;
    public static final String DESCRIPTION = "DESCRIPTION";

    UnitOfMeasureCommandToUnitOfMeasure converter;

    @BeforeEach
    void setUp() {
        converter = new UnitOfMeasureCommandToUnitOfMeasure();
    }

    @Test
    void nullObject() {
        assertNull(converter.convert(null));
    }

    @Test
    void emptyObject() {
        assertNotNull(converter.convert(new UnitOfMeasureCommand()));
    }

    @Test
    void convert() {
        //given
        UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(ID_VALUE);
        unitOfMeasureCommand.setDescription(DESCRIPTION);
        //when
        UnitOfMeasure unitOfMeasure = converter.convert(unitOfMeasureCommand);
        //then
        assertNotNull(unitOfMeasure);
        assertEquals(ID_VALUE, unitOfMeasure.getId());
        assertEquals(DESCRIPTION, unitOfMeasure.getDescription());
    }
}