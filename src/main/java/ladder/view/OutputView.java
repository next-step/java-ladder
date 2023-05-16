package ladder.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Name;
import ladder.domain.Names;

public class OutputView {

    public static void printResult() {
        System.out.println("\n실행결과\n");
    }

    public static void printNames(Names names, int width) {
        System.out.println(joinString(horizontalDelimiter(Delimiter.WHITE_SPACE.value(), width), names.names()));
    }

    public static void printLadder(Ladder ladder, int width) {
        System.out.println(ladderIndicator(ladder, width));
    }

    private static String joinString(String delimiter, List<Name> list) {
        return String.join(delimiter, list.stream().map(Name::name).collect(Collectors.toList()));
    }

    private static String horizontalDelimiter(String delimiter, int length) {
        return IntStream.range(0, length)
            .mapToObj(i -> delimiter)
            .collect(Collectors.joining());
    }

    private static String ladderIndicator(Ladder ladder, int width) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Line line : ladder.lines()) {
            stringBuilder.append(verticalLine())
                .append(rightPartOfLine(line, width))
                .append(lineSeparator());
        }
        return stringBuilder.toString();
    }

    private static String lineSeparator() {
        return Delimiter.LINE_SEPARATOR.value();
    }

    private static String verticalLine() {
        return Delimiter.VERTICAL_LINE.value();
    }

    private static String rightPartOfLine(Line line, int width) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Boolean point : line.points()) {
            stringBuilder.append(horizontalDelimiter(delimiterOf(point), width))
                .append(verticalLine());
        }
        return stringBuilder.toString();
    }

    private static String delimiterOf(Boolean point) {
        return point.equals(Boolean.TRUE) ? Delimiter.HORIZONTAL_LINE.value() : Delimiter.WHITE_SPACE.value();
    }

}
