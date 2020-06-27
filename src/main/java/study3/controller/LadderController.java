package study3.controller;

import study3.domain.ExecuteResult;
import study3.domain.Height;
import study3.domain.Ladder;
import study3.domain.Players;
import study3.view.InputView;
import study3.view.ResultView;

public class LadderController {
	public static void main(String[] args) {
		
		InputView inputview = new InputView();
		
		Players players = new Players(inputview.getParticipantNames());
		
		ExecuteResult excuteResult = new ExecuteResult(inputview.getExecuteResult());
		
		Height height = new Height(inputview.inputHeight());
		
		Ladder ladder = new Ladder(players, height);
		
		ResultView resultView = new ResultView(players, ladder);
		resultView.executeResult(excuteResult.getExecuteResult());
	}
}
