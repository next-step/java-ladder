package ladder.view;

import ladder.InputDTO;
import ladder.domain.*;

import java.util.stream.Collectors;

/**
 * Created by seungwoo.song on 2022-10-18
 */
public class OutputView {

	public static final String LADDER_COLUMN_EDGE_MARK = "|";
	public static final String LADDER_COLUMN_WIDTH_NOT_EMPTY_MARK = "-";
	public static final String EMPTY_MARK = " ";

	private StringBuilder result = new StringBuilder();

	public void print(Ladder ladder, InputDTO inputDTO) {
		addNames(inputDTO);
		addLadder(ladder);

		System.out.println(result.toString());
	}

	private void addNames(InputDTO inputDTO) {
		String nameLine = inputDTO.getPersons()
			.stream()
			.map(Person::getName)
			.map(name -> lpad(name, Person.MAX_LENGTH_NAME))
			.collect(Collectors.joining(EMPTY_MARK));

		result.append(nameLine);

		changeLine();
	}

	private String lpad(String name, int maxLengthName) {
		return getMarks(maxLengthName - name.length(), EMPTY_MARK) + name;
	}

	private void addLadder(Ladder ladder) {
		ladder.getLadderRows()
			.stream()
			.forEach(this::addRow);
	}

	private void addRow(LadderRow ladderRow) {
		result.append(getMarks(4, EMPTY_MARK));

		ladderRow.getColumns()
			.stream()
			.forEach(this::addColumn);

		changeLine();
	}

	private StringBuilder changeLine() {
		return result.append(System.lineSeparator());
	}

	private void addColumn(LadderColumn column) {
		if (column instanceof LadderColumnEdge) {
			result.append(LADDER_COLUMN_EDGE_MARK);
			return;
		}

		result.append(getLadderColumnWidthMark(column));
	}

	private String getLadderColumnWidthMark(LadderColumn column) {
		if (column.isNotEmpty()) {
			return getMarks(LADDER_COLUMN_WIDTH_NOT_EMPTY_MARK);
		}

		return getMarks(EMPTY_MARK);
	}

	private String getMarks(String mark) {
		return getMarks(Person.MAX_LENGTH_NAME, mark);
	}

	private String getMarks(int cnt, String mark) {
		String result = "";
		for (int i = 0; i < cnt; i++) {
			result += mark;
		}

		return result;
	}
}
