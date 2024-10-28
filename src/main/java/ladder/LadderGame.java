package ladder;

import ladder.view.LadderInput;
import ladder.view.LadderOutput;

public class LadderGame {

    public void run() {
        LadderInput ladderInput = new LadderInput();
        Ladder ladder = new Ladder(ladderInput.participant(), ladderInput.ladderCount());

        ladder.createLines();
        LadderOutput ladderOutput = new LadderOutput(ladder.getLines(), ladder.getParticipants());
        ladderOutput.printLadder();
    }

    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame();
        ladderGame.run();

    }
}
