package ladder;

import java.util.List;
import ladder.util.StringUtils;

public class ResultView {

    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONTAL_BLANK_LINE = "     ";
    private static final String HORIZONTAL_FULL_LINE = "-----";

    public static void printResult(UserNames userNames, Ladder ladder, LadderResult gameResult, Awards awards) {
        printUserNames(userNames);
        printLadder(ladder);
        printResult(userNames, gameResult, awards);
    }

    private static void printUserNames(UserNames userNames) {
        System.out.println("실행 결과");
        System.out.println();
        System.out.print(HORIZONTAL_BLANK_LINE);
        userNames.getUserNames()
            .forEach(username -> System.out.printf("%s ", StringUtils.center(username.getName(), 5)));
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

    private static void printResult(UserNames userNames, LadderResult result, Awards awards) {
        while (true) {
            UserName userName = InputView.inputUserNameResult();
            System.out.println("실행 결과");
            if (userName.getName().equals("all")) {
                printAllUserResult(userNames, result, awards);
                break;
            }
            printFindOneUserResult(userNames, result, userName);
        }
    }

    private static void printFindOneUserResult(UserNames userNames, LadderResult result, UserName userName) {
        int userIndex = userNames.findUserIndex(userName);
        System.out.println(result.getTarget(userIndex));
    }

    private static void printAllUserResult(UserNames userNames, LadderResult result, Awards awards) {
        for (int i = 0; i < result.getValues().size(); i++) {
            System.out.println(
                userNames.getUserNames().get(i) + ":" + awards.getAwards().get(result.getTarget(i)));
        }
    }
}
