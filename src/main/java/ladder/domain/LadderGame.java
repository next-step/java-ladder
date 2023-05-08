package ladder.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LadderGame {

	private final List<Integer> finalIndexes;

	public LadderGame(Ladder ladder, Names names) {
		this.finalIndexes = new ArrayList<>();
		for (int i = 0; i < names.countOfPerson(); i++) {
			finalIndexes.add(ladder.finalIndex(i));
		}
	}

	public ResultsBoard makeResultsBoard(Names names, Results results) {
		Map<Name, Result> resultBoard = new LinkedHashMap<>();
		for (int i = 0; i < finalIndexes.size(); i++) {
			resultBoard.put(names.indexOf(i), results.indexOf(finalIndexes.get(i)));
		}
		return new ResultsBoard(resultBoard);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		LadderGame that = (LadderGame)o;
		return Objects.equals(finalIndexes, that.finalIndexes);
	}

	@Override
	public int hashCode() {
		return Objects.hash(finalIndexes);
	}
}
