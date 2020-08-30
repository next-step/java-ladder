package step2;

import step2.domain.ladder.Ladder;
import step2.domain.ladder.LadderGenerator;
import step2.dto.GameConstructData;
import step2.view.InputHere;
import step2.view.OutputHere;

public class LadderGame {

	public static void main(String[] args) {
		GameConstructData gameConstructData = InputHere.getGameConstructData();

		LadderGenerator ladderGenerator = new LadderGenerator();
		Ladder ladder = ladderGenerator.generateLadder(gameConstructData);

		OutputHere.printConstructedGame(gameConstructData.getParticipants(), ladder);

	}
}
