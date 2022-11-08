package step2.controller;

import step2.model.Line;
import step2.util.RandomLineGenerator;
import step2.model.Users;
import step2.view.InputView;
import step2.view.OutputView;

import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderController {
	public void makeLadder() {
		RandomLineGenerator randomLineGenerator = new RandomLineGenerator();
		Users users = new Users(InputView.inputUserName());
		int maxHeight = InputView.inputLadderHeight();
		List<Line> ladderList = IntStream.range(0, maxHeight)
				.mapToObj(i -> new Line(randomLineGenerator.generate(users)))
				.collect(Collectors.toList());
		OutputView.printOutput(users, ladderList);
	}
}
