package ladder;

import static ladder.view.InputView.*;
import static ladder.view.ResultView.*;

import ladder.domain.Height;
import ladder.domain.Lines;
import ladder.domain.People;
import ladder.util.PointGenerator;
import ladder.util.RandomPointGenerator;

public class LadderApplication {
	private static final PointGenerator POINT_GENERATOR = new RandomPointGenerator();

	public static void main(String[] args) {
		People people = new People(inputNames());
		Height height = new Height(inputHeight());

		Lines ladder = Lines.of(people, height, POINT_GENERATOR);

		printLadder(people, ladder);
	}
}
