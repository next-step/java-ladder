package ladder.domain;

import ladder.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

/**
 * Created by seungwoo.song on 2022-10-17
 */
public class LadderRow {

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

	public List<LadderColumn> getColumns() {
		return columns;
	}
}
