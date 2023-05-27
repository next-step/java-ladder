package ladder.view;

import ladder.domain.*;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ResultView {

    public static final String ROW = "-----";
    public static final String EMPTY_ROW = "     ";
    public static final String COLUMN = "|";
    public static final String SIX_LENGTH_FORMAT = "%6s";
    public static final String RESULT_ALL = "all";
    public static final String EXIT = "exit";

    public static void printLadderInfoMessage() {
        System.out.println("사다리 결과");
        System.out.println();
    }

    public static void printResultInfoMessage() {
        System.out.println("실행 결과");
    }

    public static void printUsers(Users users) {
        String userNames = users.users().stream()
                .map(user -> String.format(SIX_LENGTH_FORMAT, user.name()))
                .collect(Collectors.joining());

        System.out.println(userNames);
    }

    public static void printLadder(Ladder ladder) {
        ladder.lines()
                .forEach(ResultView::printLine);
    }

    private static void printLine(Line line) {
        String row = line.points().stream()
                .map(ResultView::printRowAtEachPoint)
                .collect(Collectors.joining(COLUMN));

        System.out.println(row + COLUMN);
    }

    private static String printRowAtEachPoint(Point point) {
        if (point.canMoveToLeft()) {
            return ROW;
        }
        return EMPTY_ROW;
    }

    public static void printLadderGameResult(GameResult gameResult) {
        String results = gameResult.gameResult().stream()
                .map(result -> String.format(SIX_LENGTH_FORMAT, result))
                .collect(Collectors.joining());

        System.out.println(results);
        System.out.println();
    }

    public static void printGamesResult(GameExecutionResult gameExecutionResult) {
        while (true) {
            String userName = InputView.inputNameForGetResult();
            if (EXIT.equals(userName)) {
                return;
            }

            printResultInfoMessage();
            if (RESULT_ALL.equals(userName)) {
                printAllResult(gameExecutionResult);
                System.out.println();
                continue;
            }

            Optional<String> userResult = Optional.ofNullable(gameExecutionResult.getResultByUserName(userName));
            userResult.ifPresentOrElse(result ->
                    System.out.println(result),
                    () -> System.out.println("해당 사용자가 없습니다. 다시 입력해 주세요.")
            );

            System.out.println();
        }
    }

    private static void printAllResult(GameExecutionResult gameExecutionResult) {
        Map<String, String> executionResult = gameExecutionResult.getExecutionResult();
        executionResult.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });
    }
}
