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
		List<String> rewards = InputView.inputRewards();
		int ladderHeight = InputView.inputLadderHeight();

		Ladder ladder = new Ladder(gamerNames, rewards);
		ladder.drawLadder( ladderHeight, new RandomLadderLineSupplier());
		ladder.moveAll();
		LadderResult ladderResult = ladder.getLadderGameResult();

		OutputView.printLadder(ladderResult);

		String gamerName = InputView.inputGamerNameForReward();
		OutputView.printReward(ladderResult, gamerName);
	}
}
