package ladder.domain;

import ladder.util.RandomUtil;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by seungwoo.song on 2022-10-17
 */
public class LadderRow extends AbstractList<LadderColumn> {

	private static final BooleanSupplier DEFAULT_BOOLEAN_SUPPLIER = () -> RandomUtil.random();

	private final List<LadderColumn> columns = new ArrayList<>();

	public LadderRow(int personCount) {
		this(personCount, DEFAULT_BOOLEAN_SUPPLIER);
	}

	public LadderRow(int personCount, BooleanSupplier booleanSupplier) {
		createRow(booleanSupplier, getTotalColumnCount(personCount));
	}

	private int getTotalColumnCount(int personCount) {
		return personCount + (personCount - 1);
	}

	private void createRow(BooleanSupplier booleanSupplier, int totalColumnCount) {
		columns.add(new LadderColumnEdge());
		columns.add(createFirstWidth(booleanSupplier));

		for (int i = 2; i < totalColumnCount; i++) {
			columns.add(createColumn(columns));
		}
	}

	private LadderColumn createFirstWidth(BooleanSupplier booleanSupplier) {
		return new LadderColumnWidth(booleanSupplier.getAsBoolean());
	}

	private LadderColumn createColumn(List<LadderColumn> columns) {
		if (isNextColumnEdge(columns)) {
			return new LadderColumnEdge();
		}

		return new LadderColumnWidth(!isBeforeWidthNotEmpty(this.columns));
	}

	private boolean isNextColumnEdge(List<LadderColumn> columns) {
		return columns.isEmpty() || columns.size() % 2 == 0;
	}

	private boolean isBeforeWidthNotEmpty(List<LadderColumn> columns) {
		int beforeWidthColumnIndex = columns.size() - 2;
		return columns.get(beforeWidthColumnIndex).isNotEmpty();
	}

	@Override
	public LadderColumn get(int index) {
		return columns.get(index);
	}

	@Override
	public int size() {
		return columns.size();
	}

	public void movePerson(Person person) {
		int position = person.getPosition();
		int leftPosition = position - 1;
		int rightPosition = position + 1;

		if (isColumnNotEmpty(leftPosition)) {
			person.moveLeft();
			return;
		}

		if (isColumnNotEmpty(rightPosition)) {
			person.moveRight();
		}
	}

	private boolean isColumnNotEmpty(int leftPosition) {
		return getColumn(leftPosition)
			.filter(Objects::nonNull)
			.map(LadderColumn::isNotEmpty)
			.orElse(false);
	}

	private Optional<LadderColumn> getColumn(int nextPosition) {
		if (nextPosition < 0 || nextPosition >= columns.size()) {
			return Optional.empty();
		}
		return Optional.of(get(nextPosition));
	}
}
