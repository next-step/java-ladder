package ladder.view;

import ladder.domain.*;
import ladder.dto.InputDTO;
import ladder.util.StringUtil;

import java.util.stream.Collectors;

/**
 * Created by seungwoo.song on 2022-10-18
 */
public class OutputView {

	public static final String LADDER_COLUMN_EDGE_MARK = "|";
	public static final String LADDER_COLUMN_WIDTH_NOT_EMPTY_MARK = "-";
	public static final String EMPTY_MARK = " ";
	public static final String ALL = "all";

	private StringBuilder result = new StringBuilder();

	public void print(Ladder ladder, InputDTO inputDTO) {
		addNames(inputDTO.getPersons());
		addLadder(ladder);
		addResult(inputDTO.getLadderGameResults());
		System.out.println(result.toString());
	}

	private void addResult(LadderGameResults ladderGameResults) {
		result.append(ladderGameResults.stream()
			.map(ladderGameResult -> StringUtil.lpad(ladderGameResult.getValue(), Person.MAX_LENGTH_NAME))
			.collect(Collectors.joining(StringUtil.EMPTY_MARK)));
	}

	private void addNames(Persons persons) {
		String nameLine = persons
			.stream()
			.map(Person::getName)
			.map(name -> StringUtil.lpad(name, Person.MAX_LENGTH_NAME))
			.collect(Collectors.joining(EMPTY_MARK));

		result.append(nameLine);

		changeLine();
	}

	private void addLadder(Ladder ladder) {
		ladder.forEach(this::addRow);
	}

	private void addRow(LadderLine ladderLine) {
		addMargine();

		ladderLine.forEach(point -> {
			addEdge();
			addWidth(point);
		});

		changeLine();
	}

	private StringBuilder addMargine() {
		return result.append(StringUtil.getMarks(Person.MAX_LENGTH_NAME - 1, EMPTY_MARK));
	}

	private void addEdge() {
		result.append(LADDER_COLUMN_EDGE_MARK);
	}

	private StringBuilder changeLine() {
		return result.append(System.lineSeparator());
	}

	private void addWidth(Point column) {
		result.append(getLadderColumnWidthMark(column));
	}

	private String getLadderColumnWidthMark(Point point) {
		if (point.isMark()) {
			return getMarks(LADDER_COLUMN_WIDTH_NOT_EMPTY_MARK);
		}

		return getMarks(EMPTY_MARK);
	}

	private String getMarks(String mark) {
		return StringUtil.getMarks(Person.MAX_LENGTH_NAME, mark);
	}

	public void print(LadderGameResults ladderGameResults, InputDTO inputDTO, String selectedPerson) {
		if (ALL.equals(selectedPerson)) {
			printSingleResult(ladderGameResults, inputDTO.getPersons());
			return;
		}

		printMultiResult(ladderGameResults, inputDTO.getPersons().get(selectedPerson));
	}

	private void printMultiResult(LadderGameResults gameResults, Person selectedPerson) {
		LadderGameResult gameResult = gameResults.get(selectedPerson);
		System.out.println(gameResult.getValue());
	}

	private void printSingleResult(LadderGameResults gameResults, Persons selectedPersons) {
		for (Person person : selectedPersons) {
			LadderGameResult gameResult = gameResults.get(person);
			System.out.println(String.format("%s : %s", person.getName(), gameResult.getValue()));
		}
	}
}
