package nextstep.ladder;

import nextstep.ladder.controller.LadderGameController;
import nextstep.ladder.exception.GameExitException;

public class Game {
	public static void main(String args[]) {
		try {
			new LadderGameController().run();
		} catch (GameExitException e) {
			System.out.println(e.getMessage());
		}
	}
}
