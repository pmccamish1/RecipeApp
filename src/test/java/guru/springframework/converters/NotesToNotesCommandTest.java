package guru.springframework.converters;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import guru.springframework.commands.NotesCommand;
import guru.springframework.domain.Notes;

public class NotesToNotesCommandTest {
	public final static Long id = new Long(1L);
	public final static String description = "notes";
	NotesToNotesCommand converter;
	
	@Before
	public void setUp() throws Exception {
		converter = new NotesToNotesCommand();
	}

	public void TestNullParameter() {
		assertNull(converter);
	}
	@Test
	public void testConvert() {
		//fail("Not yet implemented");
		Notes source = new Notes();
		source.setId(id);
		source.setRecipeNotes(description);
		NotesCommand notesCommand = converter.convert(source);
		assertNotNull(notesCommand);
		assertEquals(id,notesCommand.getId());
		assertEquals(description,notesCommand.getRecipeNotes());
	}

}
