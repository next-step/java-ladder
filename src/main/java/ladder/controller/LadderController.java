package ladder.controller;

import ladder.model.Height;
import ladder.model.Lines;
import ladder.model.Players;
import ladder.model.Result;
import ladder.service.LadderCreate;
import ladder.view.LadderInputView;
import ladder.view.LadderOutputView;

public class LadderController {

	public static void main(String[] args) {
		Players players = new Players(LadderInputView.inputParticipationPlayer());
		Result result = new Result(LadderInputView.inputGameResult(),players);
		Height height = new Height(LadderInputView.inputLadderHeight());

		Lines ladderLines = LadderCreate.createLadder(players, height);

		LadderOutputView.printLadderGameResultStart();
		LadderOutputView.printPlayersName(players);
		LadderOutputView.printResultCreateLadder(ladderLines);
	}
}
