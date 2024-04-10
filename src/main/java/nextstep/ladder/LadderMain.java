package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Names;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderMain {
	public static void main(String[] args){
		InputView inputView = new InputView();
		OutputView outputView = new OutputView();
		final Names names = new Names(inputView.inputNames());
		final int height = inputView.inputLadderHeight();

		final Ladder ladder = new Ladder(names.getNumberOfNames(), height);

		outputView.printLadder(names, ladder);
	}
}
