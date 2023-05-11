package ladder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {

    private enum Indicator {
        WHITE_SPACE(" "),
        HORIZONTAL_LINE("-"),
        VERTICAL_LINE("|");

        private final String value;

        Indicator(String value) {
            this.value = value;
        }
    }

    public static void printNames(Names names, int width) {
        System.out.println(joinString(concatDelimiter(Indicator.WHITE_SPACE.value, width), names.names()));
    }

    private static String joinString(String delimiter, List<String> list) {
        return String.join(delimiter, list);
    }

    private static String concatDelimiter(String delimiter, int length) {
        return widthIndicator(length, delimiter);
    }

    public static void printLadder(Ladder ladder, int width) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Line line : ladder.lines()) {
            stringBuilder.append(widthIndicator(width / 5, Indicator.WHITE_SPACE.value));
            stringBuilder.append(Indicator.VERTICAL_LINE.value);
            for (Boolean point : line.points()) {
                stringBuilder.append(widthIndicator(width,
                    (point.equals(Boolean.TRUE)) ? Indicator.HORIZONTAL_LINE.value
                        : Indicator.WHITE_SPACE.value));
                stringBuilder.append(Indicator.VERTICAL_LINE.value);
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }

    private static String widthIndicator(int width, String WHITE_SPACE) {
        return IntStream.range(0, width)
            .mapToObj(i -> WHITE_SPACE)
            .collect(Collectors.joining());
    }

    public static void printResult() {
        System.out.println("\n실행결과\n");
    }

}
