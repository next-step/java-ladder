package ladder;

import ladder.domain.ladder.Ladder;
import ladder.ui.InputView;
import ladder.ui.ResultView;

public class LadderApplication {

	public static void main(String[] args) {

		String playersName = InputView.inputPlayersName();
		int ladderHeight = InputView.inputLadderHeight();

		Ladder ladder = Ladder.of(playersName, ladderHeight);

		ResultView.printLadder(ladder);

	}

}
