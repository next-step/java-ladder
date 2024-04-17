package nextstep.ladder;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderResult;
import nextstep.ladder.domain.LadderResultDeterminer;
import nextstep.ladder.domain.LadderResultManager;
import nextstep.ladder.domain.Names;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.OutputView;

public class LadderMain {
	public static void main(String[] args){
		InputView inputView = new InputView();
		OutputView outputView = new OutputView();
		final Names names = new Names(inputView.inputNames());
		final LadderResult ladderResult = new LadderResult(inputView.inputResult());
		final Height height = new Height(inputView.inputLadderHeight());
		final Ladder ladder = new Ladder(names.getNumberOfNames(), height);

		outputView.printLadder(names, ladder);
		final LadderResultDeterminer determiner = new LadderResultDeterminer(ladderResult, names);
		final LadderResultManager ladderResultManager = new LadderResultManager(names);
		ladderResultManager.update(ladder, determiner);
		outputView.printResult(inputView.inputName(), ladderResultManager);
	}
}
