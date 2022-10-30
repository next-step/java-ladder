package ladder;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ResultView {

    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONTAL_BLANK_LINE = "     ";
    private static final String HORIZONTAL_FULL_LINE = "-----";

    public static void printResult(UserNames userNames, Ladder ladder, Map<Integer, Integer> gameResult, List<String> awards) {
        printUserNames(userNames);
        printLadder(ladder);
        printResult(userNames, gameResult, awards);
    }

    private static void printUserNames(UserNames userNames) {
        String blank = " ";
        System.out.println("실행 결과");
        System.out.println();
        userNames.getUserNames().forEach(username -> System.out.printf("%4s", username.getName() + blank));
        System.out.println();
    }

    private static void printLadder(Ladder ladder) {
        ladder.getLadderLines()
            .forEach(ResultView::printLowLine);
    }

    private static void printLowLine(Row row) {
        List<Boolean> points = row.getPoints();

        System.out.print(HORIZONTAL_BLANK_LINE);
        for (Boolean point : points) {
            printConnectLine(point);
        }
        System.out.println();
    }

    private static void printConnectLine(Boolean point) {
        if (point) {
            System.out.print(VERTICAL_LINE);
            System.out.print(HORIZONTAL_FULL_LINE);
        } else {
            System.out.print(VERTICAL_LINE);
            System.out.print(HORIZONTAL_BLANK_LINE);
        }
    }

    private static void printResult(UserNames userNames, Map<Integer, Integer> result, List<String> awards) {
        while (true) {
            UserName userName = InputView.inputUserNameResult();
            if (userName.getName().equals("all")) {
                System.out.println("실행 결과");
                for (Entry<Integer, Integer> entry : result.entrySet()) {
                    System.out.println(userNames.getUserNames().get(entry.getKey()) + ":" + awards.get(entry.getValue()));
                }
                break;
            }
            System.out.println("실행 결과");
            int userIndex = userNames.findUserIndex(userName);
            System.out.println(result.get(userIndex));
        }
    }
}
