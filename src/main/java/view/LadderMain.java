package view;

import domain.GameLevel;
import domain.Ladder;
import domain.LadderGameInfo;
import domain.LadderResult;
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
		GameLevel gameLevel = GameLevel.findLineSupplierByLevel(InputView.inputLadderLevel());

		Ladder ladder = new Ladder(gamers.size());
		ladder.drawLadder(gameLevel);
		ladder.moveAll();
		LadderResult ladderResult = ladder.getLadderGameResult();

		OutputView.printLadder(ladderResult, ladderGameInfo);

		String gamerName = InputView.inputGamerNameForReward();
		OutputView.printReward(ladderResult, ladderGameInfo, gamerName);
	}
}
