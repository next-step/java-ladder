package ladder.view;

import ladder.domain.Lines;
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

    public static void printLadder(List<Name> names, Lines lines, int ladderMaximumHeight) {
        printResult();
        printParticipants(names);
        drawingLadder(lines, ladderMaximumHeight);
    }

    private static void printParticipants(List<Name> names) {
        names.stream()
                .map(name -> StringUtil.padRight(name.getName(), REPEAT) + EMPTY)
                .forEach(System.out::print);
        System.out.println();
    }

    private static void drawingLadder(Lines lines, int ladderMaximumHeight) {
        IntStream.range(0, ladderMaximumHeight)
                .mapToObj(j -> lines)
                .forEach(OutputUi::printLine);
    }

    private static void printLine(Lines lines) {
        StringBuilder sb = new StringBuilder();
        sb.append(STEP);
        Collections.reverse(lines.getLines());
        lines.getLines().forEach(line -> {
            sb.append(line.getLine() ? LINE : StringUtil.padRight(EMPTY, REPEAT));
            sb.append(STEP);
        });
        System.out.println(sb);
    }
}
