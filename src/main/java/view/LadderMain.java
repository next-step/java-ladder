package view;

import domain.*;
import domain.gamer.Gamers;
import domain.reward.Rewards;

/**
 * Created by hspark on 16/11/2018.
 */
public class LadderMain {
	public static void main(String[] args) {
		Gamers gamers = new Gamers(InputView.inputGamers());
		Rewards rewards = new Rewards(InputView.inputRewards());
		LadderGameInfo ladderGameInfo = new LadderGameInfo(gamers, rewards);
		int ladderHeight = InputView.inputLadderHeight();

		Ladder ladder = new Ladder(gamers.size());
		ladder.drawLadder(ladderHeight, new RandomLadderLineSupplier());
		ladder.moveAll();
		LadderResult ladderResult = ladder.getLadderGameResult();

		OutputView.printLadder(ladderResult, ladderGameInfo);

		String gamerName = InputView.inputGamerNameForReward();
		OutputView.printReward(ladderResult, ladderGameInfo, gamerName);
	}
}
