package ladder;

import ladder.domain.ladder.Ladder;
import ladder.ui.InputView;

public class LadderApplication {

	public static void main(String[] args) {

		String playersName = InputView.inputPlayersName();
		int ladderHeight = InputView.inputLadderHeight();

		System.out.println("playersName = " + playersName);
		System.out.println("ladderHeight = " + ladderHeight);

	}

}
