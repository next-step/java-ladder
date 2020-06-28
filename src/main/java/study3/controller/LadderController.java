package study3.controller;

import java.util.List;

import study3.domain.ExecuteResult;
import study3.domain.Height;
import study3.domain.Ladder;
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
		
		ExecuteResult executeResult = new ExecuteResult(inputview.getExecuteResult());
		
		Height height = new Height(inputview.inputHeight());
		
		Ladder ladder = new Ladder(players, height);
		
		ResultView resultView = new ResultView(players, ladder);
		
		Rewards rewards = resultView.executeResult(executeResult.getExecuteResult());
		
		// TODO Results results = new Results(players, ladder, rewards);
		
		
		while(true) {
			String resultName = inputview.wantResult();
			
			if(WANT_ALL.equals(resultName)) {
				Results results = Results.of(players, ladder, rewards);
				resultView.allRewardPrint(results);
			}
		}
	}
}
