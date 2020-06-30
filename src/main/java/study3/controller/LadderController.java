package study3.controller;

import java.util.List;

import study3.domain.LadderExecuteResult;
import study3.domain.LadderLine;
import study3.domain.Height;
import study3.domain.Players;
import study3.domain.Results;
import study3.domain.Rewards;
import study3.view.InputView;
import study3.view.ResultView;

public class LadderController {
	private static final String WANT_ALL = "all";

	public static void main(String[] args) {

		InputView inputview = new InputView();

		Players players = new Players(inputview.getParticipantNames());

		LadderExecuteResult executeResult = new LadderExecuteResult(inputview.getExecuteResult());

		Height height = new Height(inputview.inputHeight());

		LadderLine ladder = new LadderLine(players, height);

		ResultView resultView = new ResultView();
		resultView.viewPlayerList(players); // players 출력
		resultView.viewRowAndColumn(ladder); // 사다리 출력
		
		String inputExecute = executeResult.getExecuteResult();
		resultView.executeResult(inputExecute);
		
		Rewards rewards = LadderExecuteResult.executeReward(inputExecute);

		while (true) {
			String resultName = inputview.wantResult();

			Results results = Results.ofAll(players, ladder, rewards);
			if (resultName.equals(WANT_ALL)) {
				resultView.allRewardPrint(results);
				break;
			}
			resultView.SingleRewardPrint(results, resultName);
		}
	}
}
