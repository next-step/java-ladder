package step2;

import step2.domain.LadderGame;
import step2.domain.ladder.Ladder;
import step2.impl.RandomBooleanSupplier;
import step2.view.InputView;
import step2.view.OutputView;

public class LadderApplication {

	private static final InputView INPUT_VIEW = new InputView();
	private static final OutputView OUTPUT_VIEW = new OutputView();

	public static void main(String[] args) {

		LadderGame ladderGame = new LadderGame(INPUT_VIEW.askPlayers(), INPUT_VIEW.askExecutionResults());
		Ladder ladder = new Ladder(ladderGame.numberOfPlayer(), INPUT_VIEW.askHeight(), new RandomBooleanSupplier());
		OUTPUT_VIEW.showCreationResult(ladderGame, ladder);

		String playerName = INPUT_VIEW.askPlayerName();
		while (!ladderGame.isEnd(playerName)) {
			OUTPUT_VIEW.show(ladderGame.personalResult(ladder, playerName));
			playerName = INPUT_VIEW.askPlayerName();
		}

		OUTPUT_VIEW.showGameResult(ladderGame.gameResult(ladder));
		INPUT_VIEW.close();
	}
}
