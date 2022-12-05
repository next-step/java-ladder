package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.List;

public class ResultView {
    private static final int MAX_LENGTH_OF_PRINT_NAME = 6;
    private static final int MAX_LENGTH_OF_PRINT_RESULT = 6;
    private static final String TARGET_IS_ALL = "all";
    private static final String COLON_WITH_SPACE = " : ";
    private static final String LONG_SPACE = "     ";
    private static final String SMALL_SPACE = " ";
    private static final String LADDER_LINE = "|-----";
    private static final String LADDER_NO_LINE = "|     ";

    public static void showName(Names playerNames) {
        playerNames.names()
            .stream()
            .map(Name::name)
            .map(name ->
                makeName(name))
            .forEach(name -> System.out.print(name));

        System.out.println(SMALL_SPACE);
    }

    public static void showLadder(Ladder ladder) {
        ladder.ladder()
            .stream()
            .map(Line::line)
            .forEach(line -> showLine(line));
    }

    public static void showResult(Result result) {
        result.results()
            .stream()
            .map(ResultView::makeResult)
            .forEach(result1 -> System.out.print(result1));
    }

    private static void showLine(List<Point> line) {
        System.out.print(LONG_SPACE);
        line.stream()
            .forEach(point -> showPoint(point));
        System.out.println(' ');
    }

    private static void showPoint(Point point) {
        if (point.direction() == Direction.RIGHT) {
            System.out.print(LADDER_LINE);
            return;
        }
        System.out.print(LADDER_NO_LINE);
    }

    private static String makeResult(String result) {
        StringBuilder builder = new StringBuilder();
        int space = (MAX_LENGTH_OF_PRINT_RESULT - result.length());
        for (int i = 0; i < space; i++) {
            builder.append(SMALL_SPACE);
        }
        builder.append(result);
        return builder.toString();
    }

    private static String makeName(String name) {
        StringBuilder builder = new StringBuilder();
        int space = MAX_LENGTH_OF_PRINT_NAME - name.length();
        for (int i = 0; i < space; i++) {
            builder.append(SMALL_SPACE);
        }
        builder.append(name);
        return builder.toString();
    }

    public static void showTargetResult(Result result, ResultOfGame resultOfGame, String target) {
        if (target.equals(TARGET_IS_ALL)) {
            showAllResult(result, resultOfGame);
            return;
        }
        System.out.println(result.result(resultOfGame.targetResult(target)));
    }

    public static void showAllResult(Result result, ResultOfGame resultOfGame) {
        StringBuilder builder = new StringBuilder();
        List<Integer> results = resultOfGame.allResult();

        for (int i = 0; i < results.size(); i++) {
            builder.append(resultOfGame.names().names().get(i).name());
            builder.append(COLON_WITH_SPACE);
            builder.append(result.result(results.get(i)));
            builder.append("\n");
        }
        System.out.println(builder);
    }
}
