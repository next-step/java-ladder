package ladder.view;

import ladder.dto.InputDTO;
import ladder.domain.*;
import ladder.util.StringUtil;

import java.util.List;
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
		addNames(inputDTO.getPersons());
		addLadder(ladder);
		addResult(inputDTO.getLadderGameResults());
		System.out.println(result.toString());
	}

	private void addResult(LadderGameResults ladderGameResults) {
		result.append(ladderGameResults.values());
	}

	private void addNames(List<Person> persons) {
		String nameLine = persons
			.stream()
			.map(Person::getName)
			.map(name -> StringUtil.lpad(name, Person.MAX_LENGTH_NAME))
			.collect(Collectors.joining(EMPTY_MARK));

		result.append(nameLine);

		changeLine();
	}

	private void addLadder(Ladder ladder) {
		ladder.stream()
			.forEach(this::addRow);
	}

	private void addRow(LadderRow ladderRow) {
		result.append(StringUtil.getMarks(Person.MAX_LENGTH_NAME - 1, EMPTY_MARK));

		ladderRow.stream()
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
		return StringUtil.getMarks(Person.MAX_LENGTH_NAME, mark);
	}


}
