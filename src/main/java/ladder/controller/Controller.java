package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Controller {
	private static final InputView inputView = new InputView();
	private static final ResultView resultView = new ResultView();

	public void run() {
		String inputName = inputView.getString("참여할 사람의 이름을 입력하세요. 이름은 쉼표(,)로 구분하세요.");
		Integer inputLadderSize = inputView.getInt("최대 사다리 높이는 몇 개인가요?");

		try {
			Players players = new Players(inputName);
			makeLadder(players, inputLadderSize);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
		}
	}

	private void makeLadder(Players players, Integer inputLadderSize) {
		Ladder ladder = new Ladder(players.size(), inputLadderSize);
		resultView.printResultHead();
		resultView.printPlayer(players);
		resultView.printLadder(ladder);
	}
}
