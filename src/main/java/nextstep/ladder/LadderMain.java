package nextstep.ladder;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderFactory;
import nextstep.ladder.domain.Players;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderMain {

	public static void main(String[] args) {
		Players players = Players.from(InputView.inputPlayerNames());
		Height height = new Height(InputView.inputLadderHeight());
		Ladder ladder = LadderFactory.from(players, height);

		ResultView.printPlayerNames(players);
		ResultView.printLadder(ladder);
	}

}
