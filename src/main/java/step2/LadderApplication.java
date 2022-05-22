package step2;

import java.util.function.BooleanSupplier;

import step2.domain.Results;
import step2.domain.ladder.Height;
import step2.domain.ladder.Ladder;
import step2.domain.player.Players;
import step2.impl.RandomBooleanSupplier;
import step2.view.InputView;
import step2.view.OutputView;

public class LadderApplication {

	private static final String END_FLAG = "ALL";
	private static final InputView INPUT_VIEW = new InputView();
	private static final OutputView OUTPUT_VIEW = new OutputView();

	public static void main(String[] args) {

		BooleanSupplier supplier = new RandomBooleanSupplier();

		Players players = new Players(INPUT_VIEW.askPlayers());
		Results results = new Results(INPUT_VIEW.askExecutionResults(), players.numberOfPlayer());
		Height height = new Height(INPUT_VIEW.askHeight());
		Ladder ladder = new Ladder(players.numberOfPlayer(), height, supplier);
		OUTPUT_VIEW.showCreationResult(players, ladder, results);

		String playerName = INPUT_VIEW.askPlayerName();
		while (!END_FLAG.equals(playerName)) {
			OUTPUT_VIEW.show(results.toResult(ladder.calculateResultIndex(players.findIndexByName(playerName))));
			playerName = INPUT_VIEW.askPlayerName();
		}

		OUTPUT_VIEW.showAllResult();
		for (int index = 0; index < players.numberOfPlayer(); index++) {
			OUTPUT_VIEW.showResultWithName(players.findPlayerNameByIndex(index),
				results.toResult(ladder.calculateResultIndex(index)));
		}

		INPUT_VIEW.close();
	}
}
