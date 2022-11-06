package step2;

import step2.controller.LadderController;

public class MainApplication {
	public static void main(String[] args) {
		LadderController ladderController = new LadderController();
		ladderController.makeLadder();
	}
}
