package nextstep.ladder.controller;

import nextstep.ladder.entity.Ladder;
import nextstep.ladder.entity.PrizeResult;
import nextstep.ladder.entity.ScoreBoard;
import nextstep.ladder.entity.Users;
import nextstep.ladder.views.InputView;
import nextstep.ladder.views.OutputView;

public class LadderGameController {
	private final InputView inputView;
	private final OutputView outputView;

	public LadderGameController() {
		this.inputView = new InputView();
		this.outputView = new OutputView();
	}

	public void run() {
		String name = inputView.getUserName();
		Users users = new Users(name);

		int ladderHeight = inputView.getLadderHeight();
		PrizeResult prizeResult = makePrizeResult(users.getUserCount());

		Ladder ladder = new Ladder(users, ladderHeight);
		outputView.showResult(ladder, prizeResult);

		Ladder moveLadder = ladder.moveLadder();
		ScoreBoard scoreBoard = new ScoreBoard(moveLadder.getUsers(), prizeResult);
		while(true) {
			String participant = inputView.getParticipant();
			showResult(scoreBoard, participant);
		}
	}

	private PrizeResult makePrizeResult(int userSize) {
		String prizeResult = inputView.getPrizeResult();
		return new PrizeResult(prizeResult, userSize);
	}

	private void showResult(ScoreBoard scoreBoard, String participant) {
		if ("all".equals(participant)) {
			outputView.showAllResult(scoreBoard.getAllResult());
			return;
		}
		outputView.showResultParticipant(scoreBoard.getPrizeResultStr(participant));
	}
}
