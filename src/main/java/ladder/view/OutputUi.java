package ladder.view;

import ladder.domain.Line;
import ladder.domain.Name;
import ladder.utils.StringUtil;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class OutputUi {
    private static final String EMPTY = "";
    private static final Integer REPEAT = 5;
    private static final String STEP = "|";
    private static final String LINE = "-----";

    private static void printResult() {
        System.out.println("실행결과");
    }

    public static void printLadder(List<Name> names, Line line) {
        printResult();
        printParticipants(names);
        drawingLadder(names, line);
    }

    private static void printParticipants(List<Name> names) {
        names.stream()
                .map(name -> StringUtil.padRight(name.getName(), REPEAT) + EMPTY)
                .forEach(System.out::print);
        System.out.println();
    }

    private static void drawingLadder(List<Name> names, Line line) {
        IntStream.range(0, line.getPoints().size()).forEach(j -> printLine(names, j, line));
    }

    private static void printLine(List<Name> names, int count, Line line) {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, names.size()).forEach(i -> {
            sb.append(STEP);
            if (i != names.size() - 1) {
                Collections.reverse(line.getPoints());
                sb.append(line.getPoints().get(count) ? LINE : StringUtil.padRight(EMPTY, REPEAT));
            }
        });
        System.out.println(sb);
    }
}
