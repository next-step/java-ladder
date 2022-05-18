package step2.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.stream.Collectors;

import step2.util.ErrorTarget;
import step2.util.Validator;

public class Ladder {

	private static final int MIN_NUMBER_OF_PLAYER = 2;
	private final List<Line> lines = new ArrayList<>();

	public Ladder(int numberOfPlayer, Height height, BooleanSupplier supplier) {
		Validator.notNull(height, ErrorTarget.HEIGHT);
		Validator.notNull(supplier, ErrorTarget.SUPPLIER);
		Validator.min(MIN_NUMBER_OF_PLAYER, numberOfPlayer,
			String.format("플레이어의 수는 최소 %d 명 이어야합니다. 입력 : %d", MIN_NUMBER_OF_PLAYER, numberOfPlayer));

		for (int i = 0; i < height.getValue(); i++) {
			lines.add(new Line(numberOfPlayer, supplier));
		}
	}

	public List<Line> getLines() {
		return lines;
	}

	@Override
	public String toString() {
		return lines.stream()
			.map(Line::toString)
			.collect(Collectors.joining("\n"));
	}
}
