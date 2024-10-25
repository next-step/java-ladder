package ladder;

import ladder.view.LadderInput;
import ladder.view.LadderOutput;

public class LadderGame {

    public void run() {
        LadderInput ladderInput = new LadderInput();
        InformationForGame informationForGame = ladderInput.participant();

        informationForGame.createLines();
        LadderOutput ladderOutput = new LadderOutput(informationForGame.getLines(), informationForGame.getParticipants());
        ladderOutput.printLadder();
    }

    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame();
        ladderGame.run();

    }
}
