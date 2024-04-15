package nextstep.ladder.domain;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.domain.Name;
import nextstep.ladder.domain.Names;

public class LadderResultDeterminer {

	private final LadderResult ladderResult;
	private final Ladder ladder;
	private final Names names;

	public LadderResultDeterminer(final LadderResult ladderResult, final Ladder ladder, final Names names) {
		this.ladderResult = ladderResult;
		this.ladder = ladder;
		this.names = names;
	}

	public String determineResult(final Name name) {
		int row = names.findStartRow(name);
		int column = 0;
		while (column != ladder.getLines().size()) {
			row += ladder.move(row, column);
			column++;
		}
		return ladderResult.getResultByIndex(row);
	}
}
