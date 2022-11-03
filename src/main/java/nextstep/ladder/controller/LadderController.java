package nextstep.ladder.controller;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.participant.Participants;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderController {

	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();
	private Participants participants;
	private Ladder ladder;

	public void start() {
		participants = new Participants(inputView.getParticipants());
		ladder = new Ladder(participants.size(), inputView.getLadderHeight());
	}

	public void draw() {
		outputView.printResult(participants, ladder);
	}
}
