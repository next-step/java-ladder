package nextstep.ladder;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.Rewards;
import nextstep.ladder.ui.InputView;
import nextstep.ladder.ui.ResultView;

public class Application {
	public static void main(String[] args) {
		Participants participants = new Participants(InputView.inputParticipantNames());

		Rewards rewards = new Rewards(InputView.inputRewards());

		LadderGame game = new LadderGame(participants, rewards, InputView.inputMaximumHeight());

		ResultView.drawLadderResult(participants, game.ladder(), rewards);

		game.play();

		String input = "";
		while(!(input = InputView.inputResultName()).equals("all")) {
			ResultView.drawResult(game.gameResult(input));
		}

		ResultView.drawAllResult(game.gameResultAll());
	}
}
