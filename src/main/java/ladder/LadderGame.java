package ladder;

import ladder.domain.Ladder;
import ladder.domain.People;
import ladder.view.InputView;

public class LadderGame {

    private static final InputView INPUT_VIEW;

    static {
        INPUT_VIEW = InputView.getInstance();
    }

    public static void main(String[] args) {
        People people = People.of(INPUT_VIEW.inputParticipantsByClient());
        int height = INPUT_VIEW.inputLadderHeightByClient();
        Ladder ladder = Ladder.from(people, height);
    }
}
