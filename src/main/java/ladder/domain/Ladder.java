package ladder.domain;

import java.util.List;

/**
 * Created by seungwoo.song on 2022-10-17
 */
public class Ladder { // TODO 특별한 역할이없는데 일급 컬렉션을 사용해야할까?

	private final List<LadderRow> ladderRows;

	public Ladder(List<LadderRow> ladderRows) {
		this.ladderRows = ladderRows;
	}

	public List<LadderRow> getLadderRows() {
		return ladderRows;
	}
}
