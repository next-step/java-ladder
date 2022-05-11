package nextstep.ladder;

import java.util.List;
import java.util.Random;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.view.LadderGameInputCui;
import nextstep.ladder.view.LadderGameOutputCui;

public class MainApp {

    public static void main(String[] args) {
        LadderGameInputCui inputUi = new LadderGameInputCui();
        LadderGameOutputCui outputUi = new LadderGameOutputCui();

        List<String> participants = inputUi.inputParticipants();
        List<String> results = inputUi.inputExecuteResult();
        int ladderHeight = inputUi.inputMaxLadderHeight();

        Ladder ladder = Ladder.of(
            participants,
            results,
            ladderHeight,
            () -> new Random().nextBoolean()
        );

        outputUi.draw(ladder);

        String resultName = null;
        while (!checkAll(resultName)) {
            resultName = inputUi.inputResultName();

            outputUi.printResultOf(ladder.checkResultOf(resultName));
        }

        outputUi.printGameResults(ladder);
    }

    public static boolean checkAll(String resultName) {
        return resultName != null && "all".equals(resultName);
    }
}
