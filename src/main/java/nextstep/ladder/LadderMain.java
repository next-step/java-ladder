package nextstep.ladder;

import nextstep.ladder.domain.Players;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderMain {

	public static void main(String[] args) {
		String names = InputView.inputPlayerNames();
		int height = InputView.inputLadderHeight();

		Players players = new Players(names);
		ResultView.printPlayerNames(players);
	}

}
