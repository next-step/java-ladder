package nextstep.ladder.controller;

import java.util.List;

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
		List<String> names = inputView.getParticipants();
		participants = new Participants(names);

		int height = inputView.getLadderHeight();

		ladder = new Ladder(participants.size(), height);
	}

	public void draw() {
		outputView.printResult(participants, ladder);
	}
}
