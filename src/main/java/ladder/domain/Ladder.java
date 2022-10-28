package ladder.domain;

import java.util.AbstractList;
import java.util.List;

/**
 * Created by seungwoo.song on 2022-10-17
 */
public class Ladder extends AbstractList<LadderRow> {

	private final List<LadderRow> ladderRows;

	public Ladder(List<LadderRow> ladderRows) {
		this.ladderRows = ladderRows;
	}

	@Override
	public LadderRow get(int index) {
		return ladderRows.get(index);
	}

	@Override
	public int size() {
		return ladderRows.size();
	}
}
