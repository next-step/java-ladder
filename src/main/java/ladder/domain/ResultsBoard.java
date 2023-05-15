package ladder.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public class ResultsBoard {

	private final Map<Name, Result> resultBoard;

	public ResultsBoard(Map<Name, Result> resultBoard) {
		this.resultBoard = resultBoard;
	}

	public Map<Name, Result> getResultBoard() {
		return Collections.unmodifiableMap(this.resultBoard);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ResultsBoard that = (ResultsBoard)o;
		return Objects.equals(resultBoard, that.resultBoard);
	}

	@Override
	public int hashCode() {
		return Objects.hash(resultBoard);
	}
}
