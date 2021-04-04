package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Controller {
	private final static InputView inputView = new InputView();
	private final static ResultView resultView = new ResultView();

	public void run() {
		String inputName = inputView.getString("참여할 사람의 이름을 입력하세요. 이름은 쉼표(,)로 구분하세요.");
		Integer inputLadderSize = inputView.getInt("최대 사다리 높이는 몇 개인가요?");

		try {
			Players players = makePlayers(inputName);
			makeLadder(players, inputLadderSize);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
		}
	}

	private Players makePlayers(String inputName) {
		Players players = new Players(inputName);
		return players;
	}

	private void makeLadder(Players players, Integer inputLadderSize) {
		Ladder ladder = new Ladder(players.getPlayers().size(), inputLadderSize);
		resultView.printResultHead();
		resultView.printPlayer(players);
		resultView.printLadder(ladder);
	}
}
