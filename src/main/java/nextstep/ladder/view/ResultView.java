package nextstep.ladder.view;

import nextstep.ladder.domain.ladderline.LadderLine;
import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.user.User;

import java.util.List;
import java.util.stream.IntStream;

import static nextstep.ladder.utils.CommonConstant.NUMBER_ZERO;

public class ResultView {

    private static final String PRINT_GAME_RESULT = "실행 결과";
    private static final String PRINT_LADDER_VERTICAL_LINE = "|";
    private static final String PRINT_LADDER_LINE_VISIBLE = "-----";
    private static final String PRINT_LADDER_LINE_INVISIBLE = "     ";
    private static final int PRINT_NAME_WIDTH = 6;
    private static final String SPACE = " ";

    private ResultView() {
    }

    public static void printGameResult(List<User> users, LadderLine ladderLine, List<String> results) {
        System.out.println(PRINT_GAME_RESULT);
        ResultView.printUserNames(users);
        ResultView.printLines(ladderLine);
        ResultView.printGameResults(results);
    }

    public static void printUserNames(List<User> users) {
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

    public static void printGameResults(List<String> results) {
        results.forEach(ResultView::printGameResults);
        System.out.println();
    }

    public static void printGameResults(String result) {
        int widthResult = PRINT_NAME_WIDTH - result.length();
        for (int i = NUMBER_ZERO; i < widthResult; i++) {
            System.out.print(SPACE);
        }
        System.out.print(result);
    }

    public static void printLines(LadderLine ladderLine) {
        IntStream.range(NUMBER_ZERO, ladderLine.size())
                .mapToObj(ladderLine::getLine)
                .forEach(line -> {
                    printPoins(line);
                    System.out.println();
                });
    }

    private static void printPoins(Line line) {
        IntStream.range(NUMBER_ZERO, line.size())
                .forEach(j -> {
                    boolean point = line.getPointIndex(j).isLeft();
                    printPoint(point);
                    System.out.print(PRINT_LADDER_VERTICAL_LINE);
                });
    }

    private static void printPoint(boolean point) {
        System.out.print((point) ? PRINT_LADDER_LINE_VISIBLE : PRINT_LADDER_LINE_INVISIBLE);
    }
}
