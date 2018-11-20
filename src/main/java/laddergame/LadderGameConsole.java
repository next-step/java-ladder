package laddergame;

import laddergame.domain.Ladder;
import laddergame.domain.LadderGame;
import laddergame.domain.player.Players;
import laddergame.domain.result.Printable;
import laddergame.domain.result.Results;
import laddergame.view.InputView;
import laddergame.view.ResultView;
import laddergame2.domain.generator.Complexity;
import laddergame2.domain.generator.ComplexityStrategy;

public class LadderGameConsole {

	private static final String INITIAL_CHARACTER = "";

	public static void main(String[] args) {
		Players players = Players.fromComma(InputView.inputPlayers());
		Results results = Results.fromComma(InputView.inputResults());
		LadderGame ladderGame = new LadderGame(players, results);


		// 수동 사다리 높이로 사다리 생성
		// int ladderHeight = InputView.inputLadderHeight();
		// Ladder ladder = ladderGame.generateLadder(ladderHeight);

		// 복잡도로 사다리 생성
		Complexity complexity = Complexity.from(InputView.inputComplexity());
		Ladder ladder = ladderGame.generateLadder(complexity.getLadderHeight(), new ComplexityStrategy(complexity));
		ResultView.printLadder(ladder.display());

		LadderGameRunner ladderGameRunner = new LadderGameRunner(ladder);
		String playerName = INITIAL_CHARACTER;
		while(!ladderGameRunner.isOver(playerName)) {
			playerName = InputView.inputPlayerName();
			Printable printer = ladderGameRunner.run(playerName);
			ResultView.printResult(printer);
		}
	}
}
