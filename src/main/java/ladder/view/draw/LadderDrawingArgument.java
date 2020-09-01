package ladder.view.draw;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Names;
import ladder.domain.playing.Winnings;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class LadderDrawingArgument {
	private final Names names;
	private final Ladder ladder;
	private final Winnings winnings;

	public static LadderDrawingArgument of(Names names, Ladder ladder, Winnings winnings) {
		return new LadderDrawingArgument(names, ladder, winnings);
	}

	Names getNames() {
		return this.names;
	}

	Ladder getLadder() {
		return this.ladder;
	}

	Winnings getWinnings() {
		return this.winnings;
	}

}
