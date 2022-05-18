package step2.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntSupplier;

import step2.util.Validator;

public class Ladder {

	private final List<Line> values = new ArrayList<>();

	public Ladder(int numberOfPlayer, Height height, IntSupplier supplier) {
		Validator.notNull(height);
		Validator.notNull(supplier);

		for (int i = 0; i < height.getValue(); i++) {
			values.add(new Line(numberOfPlayer, supplier));
		}
	}
}
