package ladder.controller;

import ladder.domain.InputResult;
import ladder.domain.Ladder;
import ladder.domain.LadderResult;
import ladder.domain.Players;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Controller {
	private static final InputView inputView = new InputView();
	private static final ResultView resultView = new ResultView();

	public void run() {
		String inputName = inputView.getString("참여할 사람의 이름을 입력하세요. 이름은 쉼표(,)로 구분하세요.");
		String inputResult = inputView.getString("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
		Integer inputLadderSize = inputView.getInt("최대 사다리 높이는 몇 개인가요?");

		try {
			LadderResult ladderResult = playLadderGame(inputName, inputResult, inputLadderSize);
			String inputResultName = inputView.getString("결과를 보고 싶은 사람은?");
			resultView.printFinalResult(ladderResult, inputResultName);
		} catch (IllegalArgumentException exception) {
			System.out.println(exception.getMessage());
		}
	}

	private LadderResult playLadderGame(String inputName, String inputResult, Integer inputLadderSize) {
		Players players = new Players(inputName);
		InputResult inputResults = new InputResult(inputResult, players.size());
		LadderResult ladderResult = new LadderResult();
		Ladder ladder = makeLadder(players, inputLadderSize, inputResults);
		ladderResult.calculateResult(ladder, players, inputResults);
		return ladderResult;
	}

	private Ladder makeLadder(Players players, Integer inputLadderSize, InputResult inputResults) {
		Ladder ladder = new Ladder(players.size(), inputLadderSize);
		resultView.printResultHead();
		resultView.printPlayer(players);
		resultView.printLadder(ladder);
		resultView.printInputResult(inputResults);
		return ladder;
	}
}
