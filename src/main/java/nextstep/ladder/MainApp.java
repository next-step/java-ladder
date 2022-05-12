package nextstep.ladder;

import java.util.List;
import java.util.Random;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.exception.NotExistNameException;
import nextstep.ladder.view.LadderGameInputCui;
import nextstep.ladder.view.LadderGameOutputCui;

public class MainApp {

    public static void main(String[] args) {
        LadderGameInputCui inputUi = new LadderGameInputCui();
        LadderGameOutputCui outputUi = new LadderGameOutputCui();

        List<String> inputNames = inputUi.inputParticipants();
        List<String> results = inputUi.inputExecuteResult();

        if (inputNames.size() != results.size()) {
            System.out.println("참가자 이름 수와 결과 수는 같게 입력되어야함.");
            System.exit(1);
        }

        int ladderHeight = inputUi.inputMaxLadderHeight();

        Ladder ladder = Ladder.of(
            inputNames,
            results,
            ladderHeight,
            () -> new Random().nextBoolean()
        );

        outputUi.draw(ladder);

        String resultName = null;
        while (!checkAll(resultName)) {
            resultName = inputUi.inputResultName();

            if (resultName.equals("all")) {
                break;
            }

            try {
                outputUi.printResultOf(ladder.checkResultOf(resultName));
            } catch (NotExistNameException e) {
                System.out.println("존재하지 않는 이름, 다시 입력");
            }
        }

        outputUi.printGameResults(ladder);
    }

    public static boolean checkAll(String resultName) {
        return resultName != null && "all".equals(resultName);
    }
}
