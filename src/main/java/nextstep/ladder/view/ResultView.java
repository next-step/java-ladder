package nextstep.ladder.view;

import nextstep.ladder.entity.Direction;
import nextstep.ladder.entity.Ladder;
import nextstep.ladder.entity.Line;
import nextstep.ladder.entity.Lines;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

    private ResultView() {}

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
        ladder.getLinesList().stream().map(Lines::getLines).forEach(ResultView::printOneWidth);
    }

    private static void printOneWidth(List<Line> lines) {

        for (int j = 0; j < lines.size() - 1; j++) {
            System.out.print("|");
            System.out.print(width(lines.get(j)));
        }

        System.out.println("|");
    }

    private static String width(Line line) {
        if (line.getLineDirection().equals(Direction.RIGHT)) return "-----";
        return "     ";
    }


}
