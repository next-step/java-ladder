package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.view.LadderGameInputCui;
import nextstep.ladder.view.LadderGameOutputCui;

public class MainApp {

    public static void main(String[] args) {
        LadderGameInputCui inputUi = new LadderGameInputCui();
        LadderGameOutputCui outputUi = new LadderGameOutputCui();

        Ladder ladder = Ladder.of(inputUi.inputParticipants(), inputUi.inputMaxLadderHeight());

        outputUi.draw(ladder);
    }

}
