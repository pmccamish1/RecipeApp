package guru.springframework.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;

import guru.springframework.commands.IngredientCommand;
import guru.springframework.domain.Ingredient;
import lombok.Synchronized;

public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {
	UnitOfMeasureCommandToUnitOfMeasure uomc2uom = new UnitOfMeasureCommandToUnitOfMeasure();
	
	public IngredientCommandToIngredient(UnitOfMeasureCommandToUnitOfMeasure uomc2uom) {
		super();
		this.uomc2uom = uomc2uom;
	}

	@Synchronized
	@Nullable
	@Override
	public Ingredient convert(IngredientCommand source) {
		Ingredient ingredient = new Ingredient();
		ingredient.setId(source.getId());
		ingredient.setAmount(source.getAmount());
		ingredient.setDescription(source.getDescription());
		ingredient.setUom(uomc2uom.convert(source.getUnitOfMeasure()));
		return ingredient;
	}

}
