package ladder.domain;

import java.util.List;

/**
 * Created by seungwoo.song on 2022-10-17
 */
public class Ladder {

	private final List<LadderRow> ladderRows;

	public Ladder(List<LadderRow> ladderRows) {
		this.ladderRows = ladderRows;
	}

	public List<LadderRow> getLadderRows() {
		return ladderRows;
	}
}
