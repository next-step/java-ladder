package view;

import domain.Ladder;
import domain.LadderResult;
import domain.RandomLadderLineSupplier;

import java.util.List;

/**
 * Created by hspark on 16/11/2018.
 */
public class LadderMain {
	public static void main(String[] args) {
		List<String> gamerNames = InputView.inputGamers();
		int ladderHeight = InputView.inputLadderHeight();

		Ladder ladder = new Ladder(gamerNames, ladderHeight, new RandomLadderLineSupplier());
		ladder.drawLadder();
		LadderResult ladderResult = ladder.getLadderGameResult();

		OutputView.printLadder(ladderResult);
	}
}
