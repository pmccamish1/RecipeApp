package guru.springframework.converters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import guru.springframework.commands.NotesCommand;
import guru.springframework.domain.Notes;

public class NotesCommandToNotesTest {
	public final static Long id = new Long(1L);
	public final static String description = "notes";
	NotesCommandToNotes converter;

	@Before
	public void setUp() throws Exception {
		converter = new NotesCommandToNotes();
	}

	public void TestNullParameter() {
		assertNull(converter.convert(null));
	}

	@Test
	public void testConvert() {

		NotesCommand source = new NotesCommand();
		source.setId(id);
		source.setRecipeNotes(description);
		Notes notes = converter.convert(source);
		assertNotNull(notes);
		assertEquals(id,source.getId());
		assertEquals(description,source.getRecipeNotes());
	}

}
