package nextstep.ladder.controller;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.Results;
import nextstep.ladder.domain.Width;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderController {
	public static void main(String[] args) {
		Participants participants = new Participants(ResultView.showParticipants(InputView.inputUsers()));
		Results results = new Results(ResultView.showResults(InputView.inputResults()), new Width(participants.num()));
		Height height = new Height(ResultView.showHeight(InputView.inputHeight()));
		Ladder ladder = new Ladder(new Width(participants.num()), height);

		ResultView.showParticipantsInGame(participants);
		ResultView.showLadder(ladder);
		ResultView.showResultsInGame(results);

		ResultView.showGameResults(participants, results, ladder.playGame(new Width(participants.num())));
	}
}
