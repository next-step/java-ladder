package ladder;

import ladder.domain.Ladder;
import ladder.domain.Names;
import ladder.ui.InputView;
import ladder.ui.ResultView;

public class LadderMain {

	public static void main(String[] args) {
		Names names = new Names(InputView.inputNames());
		int height = InputView.inputHeight();
		Ladder ladder = new Ladder(names.countOfPerson(), height);
		ResultView.printNames(names);
		ResultView.printLadder(ladder);
	}
}
