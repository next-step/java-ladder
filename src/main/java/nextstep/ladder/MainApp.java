package nextstep.ladder;

import java.util.Random;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.view.LadderGameInputCui;
import nextstep.ladder.view.LadderGameOutputCui;

public class MainApp {

    public static void main(String[] args) {
        LadderGameInputCui inputUi = new LadderGameInputCui();
        LadderGameOutputCui outputUi = new LadderGameOutputCui();

        Ladder ladder = Ladder.of(inputUi.inputParticipants(),
            inputUi.inputMaxLadderHeight(),
            () -> new Random().nextBoolean()
        );

        outputUi.draw(ladder);
    }

}
