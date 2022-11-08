package nextstep.ladder.controller;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.movestrategy.RandomPointStrategy;
import nextstep.ladder.domain.participant.Participants;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderController {

	public void draw() {
		InputView inputView = new InputView();
		Participants participants = new Participants(inputView.getParticipants());
		Ladder ladder = new Ladder(participants.size(), inputView.getLadderHeight(), new RandomPointStrategy());

		OutputView outputView = new OutputView();
		outputView.printResult(participants, ladder);
	}
}