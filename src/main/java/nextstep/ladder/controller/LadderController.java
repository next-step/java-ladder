package nextstep.ladder.controller;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.generator.PointGenerator;
import nextstep.ladder.generator.RandomPointGenerator;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderController {
	public void start() {
		PointGenerator generator = new RandomPointGenerator();
		Participants participants = InputView.scanParticipants();
		Height height = InputView.scanHeightOfLadder();

		Ladder ladder = Ladder.create(generator, participants.size(), height.getValue());

		ResultView.printNames(participants.getValues());
		ResultView.printLadder(ladder.values(), participants.size());
	}
}
