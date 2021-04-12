package nextstep.ladder.view;

import nextstep.ladder.entity.Direction;
import nextstep.ladder.entity.Ladder;
import nextstep.ladder.entity.Line;
import nextstep.ladder.entity.LinesOfOneHeight;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    private ResultView() {
    }

    private static String nameFormat(String username) {
        return String.format("%-5s", username);
    }

    public static void printStart() {
        System.out.println("\n실행결과\n");
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

        System.out.println("|");
    }

    private static void printLine(Line line) {
        System.out.print("|");
        System.out.print(width(line));
    }

    private static String width(Line line) {
        if (line.getLineDirection().equals(Direction.RIGHT)) return "-----";
        return "     ";
    }


}
