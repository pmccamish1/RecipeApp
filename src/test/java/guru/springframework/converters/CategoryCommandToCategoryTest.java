package guru.springframework.converters;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import guru.springframework.commands.CategoryCommand;
import guru.springframework.domain.Category;

public class CategoryCommandToCategoryTest {
	CategoryCommandToCategory converter;
	public static final String description = "description";
	public static final Long id = new Long(1L);

	@Before
	public void setUp() throws Exception {
		converter = new CategoryCommandToCategory();
	}

	public void TestNullParameter() {
		assertNull(converter.convert(null));
	}

	@Test
	public void testConvert() {
		CategoryCommand source = new CategoryCommand();
		source.setId(id);
		source.setDescription(description);
		Category category = converter.convert(source);
		assertNotNull(category);
		assertEquals(id, category.getId());
		assertEquals(description, category.getDescription());

	}

}
