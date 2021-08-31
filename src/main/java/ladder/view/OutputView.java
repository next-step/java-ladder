package ladder.view;

import ladder.domain.*;

import java.util.Map;

public class OutputView {

    private static final String LINE_TRUE = "-----";
    private static final String LINE_FALSE = "     ";
    private static final String LINE_DELIMITER = "|";

    private static final String LADDER_TITLE = "\n사다리 결과\n";
    private static final String RESULT_TITLE = "\n실행 결과";

    public static void printLadderGameInfo(Users users, Ladder ladder, WinningItems winningItems) {
        OutputView.printNames(users);
        OutputView.printLadder(ladder);
        OutputView.printItems(winningItems);
    }

    private static void printNames(Users users) {
        System.out.println(LADDER_TITLE);
        users.getNames().forEach(name -> System.out.printf("%6s", name));
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        for (int i = 0; i < ladder.size(); i++) {
            System.out.println(generateLine(ladder.line(i)));
        }
    }

    public static String generateLine(LadderLine ladderLine) {
        String lineString = "";
        for (int i = 0; i < ladderLine.size(); i++) {
            lineString += ladderLine.point(i).direction().isLeft() ? LINE_TRUE : LINE_FALSE;
            lineString += LINE_DELIMITER;
        }
        return lineString;
    }

    private static void printItems(WinningItems winningItems) {
        winningItems.getWinningItems()
                    .forEach(name -> System.out.printf("%6s", name));
        System.out.println();
    }

    public static void printResult(String name, Map<Name, String> result) {
        System.out.println(RESULT_TITLE);
        if ("all".equals(name)) {
            result.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));
            return;
        }
        System.out.println(result.get(Name.valueOf(name)));
    }
}
