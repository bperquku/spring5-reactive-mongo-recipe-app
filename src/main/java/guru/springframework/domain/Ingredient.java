package guru.springframework.domain;

import java.math.BigDecimal;
import java.util.UUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ingredient {

  @Id
  private String id = UUID.randomUUID().toString();

	private String description;
	private BigDecimal amount;

	private Recipe recipe;

	@DBRef
	private UnitOfMeasure unitOfMeasure;
	
	public Ingredient() {}
	
	public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom) {
		this.description = description;
		this.amount = amount;
		this.unitOfMeasure = uom;
	}

	public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom, Recipe recipe) {
		this.description = description;
		this.amount = amount;
		this.unitOfMeasure = uom;
		this.recipe = recipe;
	}
}
