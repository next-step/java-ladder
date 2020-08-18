package ladder;

import ladder.domain.Ladder;

import static ladder.ui.LadderDisplay.ladderResultDisplay;
import static ladder.ui.LadderInput.inputLadderHeight;
import static ladder.ui.LadderInput.inputParticipants;

public class LadderApplication {
    public static void main(String[] args) {
        Ladder ladder = Ladder.builder()
                             .participantsLine(inputParticipants())
                             .movableLines(inputLadderHeight())
                             .build()
            ;

        ladderResultDisplay(ladder);
    }
}
