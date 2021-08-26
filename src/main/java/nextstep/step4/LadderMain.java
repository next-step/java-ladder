package nextstep.step4;

import nextstep.step4.domain.Height;
import nextstep.step4.domain.Ladder;
import nextstep.step4.domain.LadderFactory;
import nextstep.step4.domain.Players;
import nextstep.step4.domain.Prizes;
import nextstep.step4.domain.Result;
import nextstep.step4.view.InputView;
import nextstep.step4.view.ResultView;

public class LadderMain {

	public static void main(String[] args) {
		Players players = Players.from(InputView.playerNames());
		Prizes prizes = Prizes.from(InputView.prizes());
		Height height = new Height(InputView.ladderHeight());
		Ladder ladder = LadderFactory.from(players, height, prizes);
		Result result = ladder.play();

		ResultView.playerNames(players);
		ResultView.ladder(ladder);
		ResultView.prizes(prizes);

		String playerName = InputView.targetPlayerName();
		ResultView.resultOfPlayer(result, playerName);
	}
}
