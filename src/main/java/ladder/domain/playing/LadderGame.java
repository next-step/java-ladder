package ladder.domain.playing;

import ladder.domain.ladder.Ladder;

public class LadderGame {

	public static int play(int indexOfUser, Ladder ladder) {
		for (int i = 0; i < ladder.getHeight(); i++) {
			indexOfUser = LadderPiece.move(indexOfUser, ladder.getLine(i));
		}
		return indexOfUser;
	}
}
