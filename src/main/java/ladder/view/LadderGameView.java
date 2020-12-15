package ladder.view;

import ladder.domain.LadderGameInformation;
import ladder.domain.LadderGameResult;

import java.util.Map;

public class LadderGameView {

    private static final String NOT_EXISTS_NAME = "Not exists name";

    public static String enterParticipants() {
        return InputView.enterParticipants();
    }

    public static int enterMaxLadderHeight() {
        return InputView.enterMaxLadderHeight();
    }

    public static String enterParticipantName() {
        return InputView.enterName();
    }

    public static void printLadders(LadderGameInformation ladderGameInformation, LadderGameResult ladderGameResult) {
        ResultView.printLadders(ladderGameInformation, ladderGameResult);
    }

    public static void printLadderGameResult(Map<String, String> ladderGameResult) {
        String name = "";
        while (!name.equals("all")) {
            name = LadderGameView.enterParticipantName();
            printGameResult(name, ladderGameResult);
        }

    }

    private static void printGameResult(String name, Map<String, String> ladderGameResult) {
        if (ladderGameResult.containsKey(name)) {
            System.out.println();
            System.out.println("실행결과");
            System.out.println(ladderGameResult.get(name));
            return;
        }

        if (name.equals("all")) {
            System.out.println();
            System.out.println("실행결과");
            ladderGameResult.forEach((key, value) ->
                    System.out.println(key + " : " + value)
            );
            return;
        }

        throw new IllegalArgumentException(NOT_EXISTS_NAME);
    }

    public static String enterLadderGameResult() {
        return InputView.enterLadderGameResult();
    }
}
