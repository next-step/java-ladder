package ladder.domain.playing;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import ladder.domain.line.Line;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class LadderPiece {

	public static int move(int width, Line line) {
		Direction direction = line.getDirectionFrom(width);
		return direction.move(width);
	}
}
