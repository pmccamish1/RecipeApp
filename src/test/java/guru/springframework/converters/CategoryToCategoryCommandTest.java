package guru.springframework.converters;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import guru.springframework.commands.CategoryCommand;
import guru.springframework.domain.Category;

public class CategoryToCategoryCommandTest {
	CategoryToCategoryCommand converter;
	private static final String description = "description";
	private static final Long id = new Long(1L);

	@Before
	public void setUp() throws Exception {
		converter = new CategoryToCategoryCommand();
	}

	public void TestNullParameter() {
		assertNull(converter.convert(null));
	}

	@Test
	public void testConvert() {
		Category source = new Category();
		source.setId(id);
		source.setDescription(description);
		CategoryCommand categoryCommand = converter.convert(source);
		assertNotNull(categoryCommand);
		assertEquals(id, categoryCommand.getId());
		assertEquals(description, categoryCommand.getDescription());
	}

}
