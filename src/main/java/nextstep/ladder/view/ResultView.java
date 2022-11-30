package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.List;

public class ResultView {
    private static final int MAX_LENGTH_OF_PRINT_NAME = 6;
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

    private static String makeName(String name) {
        StringBuilder builder = new StringBuilder();
        int space = MAX_LENGTH_OF_PRINT_NAME - name.length();

        for (int i = 0; i < space; i++) {
            builder.append(SMALL_SPACE);
        }

        builder.append(name);
        return builder.toString();
    }

}
