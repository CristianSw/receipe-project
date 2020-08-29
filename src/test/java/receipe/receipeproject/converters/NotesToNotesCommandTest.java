package receipe.receipeproject.converters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import receipe.receipeproject.commands.NotesCommand;
import receipe.receipeproject.domain.Notes;

import static org.junit.jupiter.api.Assertions.*;

class NotesToNotesCommandTest {
    public static final Long ID_VALUE = 1L;
    public static final String RECIPE_NOTES = "Note";
    NotesToNotesCommand converter;

    @BeforeEach
    void setUp() {
        converter = new NotesToNotesCommand();
    }

    @Test
    void nullObject() {
        assertNull(converter.convert(null));
    }

    @Test
    void emptyObject() {
        assertNotNull(converter.convert(new Notes()));
    }

    @Test
    void convert() {
        //given
        Notes notes = new Notes();
        notes.setId(ID_VALUE);
        notes.setRecipesNotes(RECIPE_NOTES);
        //when
        NotesCommand notesCommand = converter.convert(notes);
        //then
        assertNotNull(notesCommand);
        assertEquals(ID_VALUE, notesCommand.getId());
        assertEquals(RECIPE_NOTES, notesCommand.getRecipeNotes());
    }
}