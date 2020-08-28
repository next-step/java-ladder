package ladder.view.draw;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Names;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DrawArgument {
	private final Names names;
	private final Ladder ladder;

	public static DrawArgument of(Names names, Ladder ladder) {
		return new DrawArgument(names, ladder);
	}

	Names getNames() {
		return this.names;
	}

	Ladder getLadder() {
		return this.ladder;
	}
}
