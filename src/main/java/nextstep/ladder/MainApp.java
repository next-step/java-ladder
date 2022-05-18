package nextstep.ladder;

import java.util.List;
import java.util.Random;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.exception.NotExistNameException;
import nextstep.ladder.view.LadderGameInputCui;
import nextstep.ladder.view.LadderGameOutputCui;

public class MainApp {

    private static final LadderGameInputCui inputUi = new LadderGameInputCui();
    private static final LadderGameOutputCui outputUi = new LadderGameOutputCui();

    public static void main(String[] args) {
        List<String> inputNames = inputUi.inputParticipants();
        List<String> results = inputUi.inputExecuteResult();
        int ladderHeight = inputUi.inputMaxLadderHeight();

        Ladder ladder = Ladder.of(
            inputNames,
            results,
            ladderHeight
        );

        outputUi.draw(ladder);
        checkResult(ladder);
        outputUi.printGameResults(ladder);
    }

    private static void checkResult(Ladder ladder) {
        String resultName;
        while (!finishCheck(resultName = inputUi.inputResultName())) {
            printResult(ladder, resultName);
        }
    }

    private static void printResult(Ladder ladder, String resultName) {
        try {
            outputUi.printResultOf(ladder.checkResultOf(resultName));
        } catch (NotExistNameException e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean finishCheck(String resultName) {
        return resultName != null && "all".equals(resultName);
    }

}
