package ladder.domain;

import ladder.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by seungwoo.song on 2022-10-17
 */
public class LadderRow {

	private static final Supplier<Boolean> DEFAULT_BOOLEAN_SUPPLIER = () -> RandomUtil.random();

	private final List<LadderColumn> columns = new ArrayList<>();

	public LadderRow(int personCount) {
		this(personCount, DEFAULT_BOOLEAN_SUPPLIER);
	}

	public LadderRow(int personCount, Supplier<Boolean> booleanSupplier) {
		createRow(booleanSupplier, getTotalColumnCount(personCount));
	}

	private static int getTotalColumnCount(int personCount) {
		if (personCount == 2) {
			return 3;
		}

		return personCount + 2;
	}

	private void createRow(Supplier<Boolean> booleanSupplier, int totalColumnCount) {
		columns.add(new LadderColumnEdge());
		columns.add(createFirstWidth(booleanSupplier));

		for (int i = 2; i < totalColumnCount; i++) {
			columns.add(createColumn());
		}
	}

	private LadderColumn createFirstWidth(Supplier<Boolean> booleanSupplier) {
		return new LadderColumnWidth(booleanSupplier.get());
	}

	private LadderColumn createColumn() {
		if (isNextCreateEdge()) {
			return new LadderColumnEdge();
		}

		return new LadderColumnWidth(!isBeforeWidthNotEmpty());
	}


	private boolean isNextCreateEdge() {
		return columns.isEmpty() || columns.size() % 2 == 0;
	}

	private boolean isBeforeWidthNotEmpty() {
		int beforeWidthColumnIndex = columns.size() - 2;
		return columns.get(beforeWidthColumnIndex).isNotEmpty();
	}

	public List<LadderColumn> getColumns() {
		return columns;
	}
}
