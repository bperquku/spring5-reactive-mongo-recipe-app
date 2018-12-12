package guru.springframework.commands;

import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CategoryCommand {

	private String id;
	private String description;
	private Set<RecipeCommand> recipes;
}
