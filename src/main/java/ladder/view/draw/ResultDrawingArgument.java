package ladder.view.draw;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import ladder.domain.ladder.Names;
import ladder.domain.playing.Winnings;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ResultDrawingArgument {

	private final Winnings winnings;
	private final Names names;

	public static ResultDrawingArgument of(Winnings winnings, Names names) {
		return new ResultDrawingArgument(winnings, names);
	}

	public int getShowSize() {
		return winnings.getSize();
	}
}
