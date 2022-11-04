package ladder.view;

import java.util.List;
import ladder.ladder.Ladder;
import ladder.ladder.Row;
import ladder.result.Award;
import ladder.result.LadderResult;
import ladder.user.UserName;
import ladder.user.UserNames;

public class ResultView {

    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONTAL_BLANK_LINE = "     ";
    private static final String HORIZONTAL_FULL_LINE = "-----";

    public static void printResult(UserNames userNames, Ladder ladder, LadderResult gameResult) {
        printUserNames(userNames);
        printLadder(ladder);
        printResult(userNames, gameResult);
    }

    private static void printUserNames(UserNames userNames) {
        System.out.println("실행 결과");
        System.out.println();
        for (UserName userName : userNames.getUserNames()) {
            if (userName.getName().length() == 5) {
                System.out.println(userName.getName());
            }
            System.out.printf("%4s ", userName.getName());
        }
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
        for (int i = 0; i < result.getValues().size(); i++) {
            System.out.println(userNames.getUserNames().get(i).getName() + " : " + result.getTargetPlayer(userNames.getUserNames().get(i)).getAward());
        }
    }
}
