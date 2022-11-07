package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BooleanSupplier;

/**
 * Created by seungwoo.song on 2022-11-04
 */
public class Ladder {

	private final List<LadderLine> ladderLines;

	public Ladder(List<LadderLine> ladderLines) {
		this.ladderLines = ladderLines;
	}

	public static Ladder of(int rowCount, int personCount, BooleanSupplier booleanSupplier) {
		if (rowCount <= 0 || personCount <= 0 || booleanSupplier == null) {
			throw new IllegalArgumentException("잘못됩 입력값 입니다.");
		}

		List<LadderLine> ladderLine = new ArrayList<>();
		for (int i = 0; i < rowCount; i++) {
			ladderLine.add(LadderLine.of(personCount, booleanSupplier));
		}
		return new Ladder(ladderLine);
	}

	public int getResultIndex(int startIndex) {
		int index = startIndex;

		for (int i = 0; i < ladderLines.size(); i++) {
			LadderLine ladderLine = ladderLines.get(i);
			index = ladderLine.move(index);
			System.out.println("ladderLine = " + index);
		}

		return index;
	}

	//===================================================

	@Override public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Ladder ladder = (Ladder)o;
		return Objects.equals(ladderLines, ladder.ladderLines);
	}

	@Override public int hashCode() {
		return Objects.hash(ladderLines);
	}

	@Override public String toString() {
		return "Ladder{" +
			"ladderLines=" + ladderLines +
			'}';
	}
}
