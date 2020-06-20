package study2.controller;

import study2.domain.Height;
import study2.domain.Ladder;
import study2.domain.Players;
import study2.view.InputView;
import study2.view.ResultView;

public class LadderController {
	public static void main(String[] args) {
		
		InputView inputview = new InputView();
		
		Players players = new Players(inputview.getParticipantNames());
		Height height = new Height(inputview.InputHeight());
		
		Ladder ladder = new Ladder(players, height);
		
		ResultView resultView = new ResultView(players, ladder);		
	}
}
