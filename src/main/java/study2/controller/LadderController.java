package study2.controller;

import study2.domain.Height;
import study2.domain.Ladder;
import study2.domain.Players;
import study2.view.InputView;

public class LadderController {

	InputView inputview = new InputView();
	Players players = new Players(inputview.participateName());
	Height height = new Height(inputview.InputHeight());
	
	Ladder ladder = new Ladder(players, height);
	
}
