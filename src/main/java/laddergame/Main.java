package laddergame;

import laddergame.domain.LadderGame;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.LadderGenerator;
import laddergame.dto.GameCriteria;
import laddergame.view.InputHere;
import laddergame.view.OutputHere;

import static laddergame.view.OutputHere.RESULT_ALL_KEYWORD;

public class Main {

	private static final String EMPTY_STRING = "";

	public static void main(String[] args) {
		GameCriteria gameCriteria = InputHere.getGameCriteria();
		LadderGenerator ladderGenerator = new LadderGenerator();
		Ladder ladder = ladderGenerator.generateLadder(gameCriteria);
		LadderGame ladderGame = LadderGame.of(gameCriteria, ladder);
		OutputHere.printPreparedGame(ladderGame);
		String name = EMPTY_STRING;
		while (!RESULT_ALL_KEYWORD.equals(name)) {
			name = InputHere.getNameWantShowResult();
			OutputHere.printLadderGameResult(name, ladderGame.rumGame());
		}
	}
}
