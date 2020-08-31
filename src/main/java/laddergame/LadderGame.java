package laddergame;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.LadderGenerator;
import laddergame.dto.GameCriteria;
import laddergame.view.InputHere;
import laddergame.view.OutputHere;

import static laddergame.view.OutputHere.RESULT_ALL_KEYWORD;

public class LadderGame {

	public static void main(String[] args) {
		GameCriteria gameCriteria = InputHere.getGameCriteria();

		LadderGenerator ladderGenerator = new LadderGenerator();
		Ladder ladder = ladderGenerator.generateLadder(gameCriteria);

		OutputHere.printPreparedGame(gameCriteria, ladder);

		String name;
		do {
			name = InputHere.getNameWantShowResult();
			OutputHere.printLadderGameResult(name, gameCriteria, ladder);
		} while (!RESULT_ALL_KEYWORD.equals(name));
	}
}
