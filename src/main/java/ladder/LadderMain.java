package ladder;

import java.util.ArrayList;
import java.util.List;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Names;
import ladder.domain.Points;
import ladder.ui.InputView;
import ladder.ui.ResultView;

public class LadderMain {

	public static void main(String[] args) {
		Names names = new Names(InputView.inputNames());
		Height height = new Height(InputView.inputHeight());
		List<Points> pointsList = new ArrayList<>();
		for (int i = 0; i < height.getHeight(); i++) {
			pointsList.add(new Points(Points.generate(names)));
		}
		Ladder ladder = new Ladder(pointsList);
		ResultView.printNames(names);
		ResultView.printLadder(ladder);
	}
}
