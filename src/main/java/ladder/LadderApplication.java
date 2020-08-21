package ladder;

import ladder.domain.Ladder;
import ladder.ui.LadderDisplay;
import ladder.ui.LadderInput;

import static ladder.ui.LadderDisplay.ladderDisplay;
import static ladder.ui.LadderInput.inputLadderBaseData;

public class LadderApplication {
    public static void main(String[] args) {
        final Ladder ladder = Ladder.create(inputLadderBaseData());

        ladderDisplay(ladder);

        ladder.ridingLoop(LadderInput::inputParticipant, LadderDisplay::rideResultDisplay)
              .orAllLadderRidingResult(LadderDisplay::allRideResultDisplay);
    }
}
