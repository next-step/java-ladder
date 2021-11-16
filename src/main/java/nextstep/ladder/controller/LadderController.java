package nextstep.ladder.controller;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Persons;
import nextstep.ladder.generator.PointGenerator;
import nextstep.ladder.generator.RandomPointGenerator;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderController {
	public void start() {
		PointGenerator generator = new RandomPointGenerator();
		Persons persons = InputView.scanPersons();
		Height height = InputView.scanHeightOfLadder();

		Ladder ladder = Ladder.create(generator, persons.size(), height.getValue());

		ResultView.printNames(persons);
		ResultView.printLadder(ladder.values(), persons.size());
	}
}
