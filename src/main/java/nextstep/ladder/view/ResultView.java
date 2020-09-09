package nextstep.ladder.view;

import nextstep.ladder.domain.line.LadderLine;
import nextstep.ladder.domain.line.LadderLines;
import nextstep.ladder.domain.result.LadderResult;
import nextstep.ladder.domain.result.Results;
import nextstep.ladder.domain.user.User;
import nextstep.ladder.domain.user.Users;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static nextstep.ladder.utils.CommonConstant.NUMBER_ZERO;

public class ResultView {

    private static final String PRINT_LADDER_RESULT = "사다리 결과";
    private static final String PRINT_LADDER_VERTICAL_LINE = "|";
    private static final String PRINT_LADDER_LINE_VISIBLE = "-----";
    private static final String PRINT_LADDER_LINE_INVISIBLE = "     ";
    private static final int PRINT_NAME_WIDTH = 6;
    private static final String SPACE = " ";
    private static final String PRINT_GAME_RESULT = "실행 결과";
    private static final String PRINT_ALL_MEMBER = "all";

    private ResultView() {
    }

    private static void printLadderResult(List<User> users, LadderLines ladderLines, List<String> results) {
        System.out.println(PRINT_LADDER_RESULT);
        printUserNames(users);
        printLines(ladderLines);
        printLadderResults(results);
    }

    private static void printUserNames(List<User> users) {
        users.forEach(ResultView::printUserName);
        System.out.println();
    }

    private static void printUserName(User user) {
        int result = PRINT_NAME_WIDTH - user.getName().length();
        for (int i = NUMBER_ZERO; i < result; i++) {
            System.out.print(SPACE);
        }
        System.out.print(user.getName());
    }

    private static void printLines(LadderLines ladderLines) {
        IntStream.range(NUMBER_ZERO, ladderLines.size())
                .mapToObj(ladderLines::getLine)
                .forEach(line -> {
                    printPoins(line);
                    System.out.println();
                });
    }

    private static void printPoins(LadderLine ladderLine) {
        IntStream.range(NUMBER_ZERO, ladderLine.size())
                .forEach(j -> {
                    boolean point = ladderLine.getPointIndex(j).isLeft();
                    printPoint(point);
                    System.out.print(PRINT_LADDER_VERTICAL_LINE);
                });
    }

    private static void printPoint(boolean point) {
        System.out.print((point) ? PRINT_LADDER_LINE_VISIBLE : PRINT_LADDER_LINE_INVISIBLE);
    }

    private static void printLadderResults(List<String> results) {
        results.forEach(ResultView::printLadderResults);
        System.out.println();
    }

    private static void printLadderResults(String result) {
        int widthResult = PRINT_NAME_WIDTH - result.length();
        for (int i = NUMBER_ZERO; i < widthResult; i++) {
            System.out.print(SPACE);
        }
        System.out.print(result);
    }

    private static void printGameResult(Map<User, Integer> ladderResults, List<String> result) {
        InputView.scanner.nextLine();
        while (true) {
            String gameResult = InputView.inputGameResult();
            printByUser(gameResult, ladderResults, result);

            if (gameResult.equals(PRINT_ALL_MEMBER)) {
                System.out.println(PRINT_GAME_RESULT);
                printAllUser(ladderResults, result);
                break;
            }
        }
    }

    private static void printByUser(String gameResult, Map<User, Integer> ladderResults, List<String> result) {
        if (!gameResult.equals(PRINT_ALL_MEMBER)) {
            System.out.println(PRINT_GAME_RESULT);
            System.out.println(LadderResult.maybeUserResult(gameResult, ladderResults, result));
        }
    }

    private static void printAllUser(Map<User, Integer> ladderResults, List<String> result) {
        for (User user : ladderResults.keySet()) {
            int position = ladderResults.get(user);
            System.out.println(user.getName() + " : " + result.get(position));
        }
    }

    public static void printLadderGame(Users users, LadderLines ladderLines, Results results, LadderResult ladderResult) {
        printLadderResult(users.getUsers(), ladderLines, results.getResults());
        printGameResult(ladderResult.getLadderResult(), results.getResults());
    }

}
