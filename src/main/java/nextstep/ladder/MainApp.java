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

        validateNamesAndResult(inputNames, results);

        int ladderHeight = inputUi.inputMaxLadderHeight();

        Ladder ladder = Ladder.of(
            inputNames,
            results,
            ladderHeight,
            () -> new Random().nextBoolean()
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
            System.out.println("존재하지 않는 이름, 다시 입력");
        }
    }

    private static boolean finishCheck(String resultName) {
        return resultName != null && "all".equals(resultName);
    }

    private static void validateNamesAndResult(List<String> names, List<String> results) {
        if (names.size() != results.size()) {
            System.out.println("참가자 이름 수와 결과 수는 같게 입력되어야함.");
            System.exit(1);
        }
    }
}
