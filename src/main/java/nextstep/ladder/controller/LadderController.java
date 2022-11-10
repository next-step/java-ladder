package nextstep.ladder.controller;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.linestrategy.RandomLineGenerator;
import nextstep.ladder.domain.participant.Participants;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderController {

	public void draw() {
		InputView inputView = new InputView();
		Participants participants = new Participants(inputView.getParticipants());
		Ladder ladder = new Ladder(participants.size(), inputView.getLadderHeight(), new RandomLineGenerator());

		OutputView outputView = new OutputView();
		outputView.printResult(participants, ladder);
	}
}