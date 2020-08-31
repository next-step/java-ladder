package laddergame;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.LadderGenerator;
import laddergame.dto.GameConstructData;
import laddergame.view.InputHere;
import laddergame.view.OutputHere;

public class LadderGame {

	public static void main(String[] args) {
		GameConstructData gameConstructData = InputHere.getGameConstructData();

		LadderGenerator ladderGenerator = new LadderGenerator();
		Ladder ladder = ladderGenerator.generateLadder(gameConstructData);

		OutputHere.printConstructedGame(gameConstructData.getParticipants(), ladder);

	}
}
