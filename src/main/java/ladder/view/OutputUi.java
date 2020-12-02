package ladder.view;

import ladder.domain.Line;
import ladder.domain.Lines;
import ladder.domain.Name;
import ladder.utils.LadderUtil;
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

    public static void printLadder(List<Name> names, Lines lines) {
        printResult();
        printParticipants(names);
        drawingLadder(names, lines);
    }

    private static void printParticipants(List<Name> names) {
        names.stream()
                .map(name -> StringUtil.padRight(name.getName(), REPEAT) + EMPTY)
                .forEach(System.out::print);
        System.out.println();
    }

    private static void drawingLadder(List<Name> names, Lines lines) {
        IntStream.range(0, lines.getLines().size()).forEach(j -> printLine(names, j, lines));
    }

    private static void printLine(List<Name> names, int count, Lines lines) {
        StringBuilder sb = new StringBuilder();
        int bound = names.size();
        IntStream.range(0, bound).forEach(i -> {
            sb.append(STEP);
            sb.append(LadderUtil.isLast(i, names.size()) ? printLine(count, lines) : "");
        });
        System.out.println(sb);
    }

    private static String printLine(int count, Lines lines) {
        Collections.reverse(lines.getLines());
        return lines.getLines().get(count).getLine() ? LINE : StringUtil.padRight(EMPTY, REPEAT);
    }


}
