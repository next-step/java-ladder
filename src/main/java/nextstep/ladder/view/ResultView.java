package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Players;

public class ResultView {
	public void viewPlayers(Players players) {
		String view = players.toString();
		System.out.println(players);
	}

	public void viewLadder(Ladder ladder) {
		String view = ladder.toString();
		System.out.println(view);
	}
}
