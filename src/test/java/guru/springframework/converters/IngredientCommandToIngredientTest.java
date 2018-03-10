package guru.springframework.converters;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import guru.springframework.commands.IngredientCommand;
import guru.springframework.commands.UnitOfMeasureCommand;
import guru.springframework.domain.Ingredient;

public class IngredientCommandToIngredientTest {
	IngredientCommandToIngredient converter;
	private static final UnitOfMeasureCommand uomc = new UnitOfMeasureCommand();
	private static final String description = "description";
	private static final BigDecimal amount = new BigDecimal("2.0");
	private static final Long id = new Long(1L);
	private static final UnitOfMeasureCommandToUnitOfMeasure uomc2uom = new UnitOfMeasureCommandToUnitOfMeasure();;

	@Before
	public void setUp() throws Exception {
		converter = new IngredientCommandToIngredient(uomc2uom);
	}

	public void TestNullParameter() {
		assertNull(converter.convert(null));
	}

	@Test
	public void testIngredientCommandToIngredient() {
		// fail("Not yet implemented");
	}

	@Test
	public void testConvert() {

		IngredientCommand source = new IngredientCommand();
		source.setId(id);
		source.setAmount(amount);
		source.setDescription(description );
		source.setUnitOfMeasure(uomc );
		Ingredient ingredient = converter.convert(source);
		assertNotNull(ingredient);
		assertEquals(id, ingredient.getId());
		assertEquals(amount, ingredient.getAmount());
		assertEquals(description, ingredient.getDescription());
		assertEquals(ingredient.getUom(), uomc2uom.convert(uomc));

	}

}
