package nextstep.step4.view;

import nextstep.step4.Validator;
import nextstep.step4.domain.Ladder;
import nextstep.step4.domain.LadderLine;
import nextstep.step4.domain.User;
import nextstep.step4.resource.LadderStringResource;

import java.util.List;
import java.util.Map;

public class ResultView {
    private static final String STRING_PRINT_FORMAT = "%-6s";
    private static final String STRING_PRINT_DELIMITER = " : ";

    public static void showLadderResult(List<String> users, Ladder ladder) {
        System.out.println();
        System.out.println(LadderStringResource.LADDER_RESULT_TEXT);
        printUserName(users);
        System.out.println();
        printLadderLine(ladder.getLines());
    }

    private static void printUserName(List<String> users) {
        users.forEach(user -> System.out.printf(STRING_PRINT_FORMAT, user));
    }

    private static void printLadderLine(List<LadderLine> lines) {
        lines.forEach(line -> {
            System.out.print(LadderStringResource.BAR);
            printLine(line);
            System.out.println();
        });
    }

    private static void printLine(LadderLine line) {
        line.getPoints().stream()
                .limit(line.getPoints().size() - 1)
                .peek(point -> System.out.print(point.getDirection().isRight() ? LadderStringResource.LINE : LadderStringResource.NO_LINE))
                .forEach(point -> System.out.print(LadderStringResource.BAR));
    }

    public static void showPlayResult(List<String> playResult) {
        playResult.forEach(result -> System.out.printf(STRING_PRINT_FORMAT, result));
        System.out.println();
    }

    public static void showUserResult(User user) {
        System.out.println(LadderStringResource.PLAY_RESULT_TEXT);
        System.out.println(user.getResult());
        System.out.println();
    }

    public static void showAllResult(Map<String, User> resultMap) {
        System.out.println(LadderStringResource.PLAY_RESULT_TEXT);
        resultMap.forEach((key, value) -> System.out.println(key + STRING_PRINT_DELIMITER + value.getResult()));
        System.out.println();
    }

    public static void showFinalResult(Map<String, User> resultMap) {
        while (true) {
            String userName = Validator.checkUserNameForResult(InputView.getUserNameForResult(), resultMap);
            if (userName.equals("all")) {
                ResultView.showAllResult(resultMap);
                System.exit(0);
            }
            ResultView.showUserResult(resultMap.get(userName));
        }
    }
}
