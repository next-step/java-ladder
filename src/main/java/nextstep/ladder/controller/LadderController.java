package nextstep.ladder.controller;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderController {
	public static void main(String[] args) {
		Participants participants = new Participants(ResultView.showParticipants(InputView.inputUsers()));
		Height height = new Height(ResultView.showHeight(InputView.inputHeight()));
		Ladder ladder = new Ladder(participants, height);
		ResultView.showLadder(ladder);
	}
}
