package nextstep.ladder.view;

import nextstep.ladder.entity.ladder.Direction;
import nextstep.ladder.entity.ladder.Ladder;
import nextstep.ladder.entity.ladder.Line;
import nextstep.ladder.entity.ladder.LinesOfOneHeight;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    static final String HEIGHT_PRINT_SYMBOL = "|";
    static final String DRAW_LINE = "-----";
    static final String NONE_DRAW_LINE = "     ";
    static final String lineSeparator = System.lineSeparator();

    private ResultView() {
    }

    private static String nameFormat(String username) {
        return String.format("%-5s", username);
    }

    public static void printResult(List<String> userNames, Ladder ladder) {
        printStart();
        printUser(userNames);
        printLadder(ladder);
    }

    public static void printStart() {

        System.out.println(lineSeparator + "사다리 결과" + lineSeparator);
    }

    public static void printUser(List<String> userNames) {

        System.out.println(userNames.stream()
                .map(ResultView::nameFormat)
                .collect(Collectors.joining(" ")));
    }

    public static void printLadder(Ladder ladder) {
        for (LinesOfOneHeight linesOfOneHeight : ladder.getLines()) {
            printOneWidth(linesOfOneHeight);
        }
    }

    private static void printOneWidth(LinesOfOneHeight linesOfOneHeight) {
        int lineSize = linesOfOneHeight.getLineSize();

        IntStream.range(0, lineSize - 1)
                .mapToObj(linesOfOneHeight::positionLine)
                .forEach(ResultView::printLine);


        System.out.println(HEIGHT_PRINT_SYMBOL);
    }

    private static void printLine(Line line) {
        System.out.print(HEIGHT_PRINT_SYMBOL);
        System.out.print(width(line));
    }

    private static String width(Line line) {

        if (line.lineDirection().equals(Direction.RIGHT)) {
            return DRAW_LINE;
        }

        return NONE_DRAW_LINE;
    }

    public static void gameResult(List<String> gameResults) {
        System.out.println(lineSeparator + "실행결과");
        for (String gameResult : gameResults) {
            System.out.println(gameResult);
        }
    }
}
