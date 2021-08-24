package nextstep.ladder;

import java.util.Arrays;
import java.util.List;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderFactory;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.Result;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderMain {

	public static void main(String[] args) {
		Players players = Players.from(InputView.inputPlayerNames());
		List<String> prizes = Arrays.asList(InputView.inputPrizes().split(","));
		Height height = new Height(InputView.inputLadderHeight());
		Ladder ladder = LadderFactory.from(players, height);
		Result result = ladder.play();

		ResultView.printPlayerNames(players);
		ResultView.printLadder(ladder);
		ResultView.printPrizes(prizes);

		String playerName = InputView.inputTargetPlayerName();
		ResultView.printPrizeOfPlayer(result, prizes, playerName);
	}

}
