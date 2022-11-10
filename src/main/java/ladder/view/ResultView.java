package ladder.view;

import java.util.List;
import ladder.ladder.Ladder;
import ladder.ladder.Point;
import ladder.ladder.Row;
import ladder.result.Award;
import ladder.result.Awards;
import ladder.result.LadderResult;
import ladder.user.UserName;
import ladder.user.UserNames;

public class ResultView {

    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONTAL_BLANK_LINE = "     ";
    private static final String HORIZONTAL_FULL_LINE = "-----";

    public static void printResult(UserNames userNames, Ladder ladder, LadderResult gameResult, Awards awards) {
        printUserNames(userNames);
        printLadder(ladder);
        printAwards(awards);
        printResult(userNames, gameResult);
    }

    private static void printUserNames(UserNames userNames) {
        System.out.println("실행 결과");
        System.out.println();
        for (UserName userName : userNames.getUserNames()) {
            System.out.print(formatName(userName));
        }
        System.out.println();
    }

    private static String formatName(UserName userName) {
        if (userName.getName().length() == UserName.USER_NAME_LENGTH) {
            return userName.getName();
        }
        return String.format("%4s ", userName.getName());
    }

    private static void printLadder(Ladder ladder) {
        ladder.getLadderLines()
            .forEach(ResultView::printLowLine);
    }

    private static void printAwards(Awards awards) {
        awards.getValues().forEach(award -> System.out.printf("%-4s ", award.getAward()));
        System.out.println();
    }

    private static void printLowLine(Row row) {
        List<Point> points = row.getPoints();

        System.out.print(HORIZONTAL_BLANK_LINE);
        for (Point point : points) {
            printConnectLine(point);
        }
        System.out.println();
    }

    private static void printConnectLine(Point point) {
        System.out.print(VERTICAL_LINE);
        System.out.print(printLine(point.getDirection().isRight()));
    }

    private static String printLine(Boolean isRight) {
        if (isRight) {
            return HORIZONTAL_FULL_LINE;
        }
        return HORIZONTAL_BLANK_LINE;
    }

    private static void printResult(UserNames userNames, LadderResult result) {
        while (true) {
            UserName inputUserName = InputView.inputUserNameResult();
            System.out.println("실행 결과");
            if (inputUserName.getName().equals("all")) {
                printAllUserResult(userNames, result);
                break;
            }
            printFindOneUserResult(result, inputUserName);
        }
    }

    private static void printFindOneUserResult(LadderResult result, UserName inputUserName) {
        Award award = result.getTargetPlayer(inputUserName);
        System.out.println(award.getAward());
    }

    private static void printAllUserResult(UserNames userNames, LadderResult result) {
        for (int i = 0; i < result.size(); i++) {
            System.out.println(userNames.getUserNames().get(i).getName() + " : " + result.getTargetPlayer(userNames.getUserNames().get(i)).getAward());
        }
    }
}
