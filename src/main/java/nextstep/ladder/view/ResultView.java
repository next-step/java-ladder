package nextstep.ladder.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    private static final int NAME_LENGTH_STANDARD = 5;
    private static final String RESULT = "실행결과";
    private static final String DELIMITER = "|";
    private static final String CONNECTED = "-----";
    private static final String UNCONNECTED = "     ";
    private static final String BLANK = "   ";

    public void printResult(List<String> names, List<List<Boolean>> lines) {
        printResultPhrase();
        printPlayerNames(convertNames(names));
        lines.forEach(this::printLine);
    }

    private List<String> convertNames(List<String> names) {
        return names.stream()
                .map(this::addBlankInName)
                .collect(Collectors.toList());
    }

    private String addBlankInName(String name) {
        int nameLength = name.length();
        StringBuilder stringBuilder = new StringBuilder();

        IntStream.range(0, NAME_LENGTH_STANDARD - nameLength)
                .forEach((i) -> stringBuilder.append(" "));

        return name + stringBuilder.toString();
    }

    private void printPlayerNames(List<String> names) {
        names.forEach(name -> System.out.print(name + " "));
        System.out.println();
    }

    private void printLine(List<Boolean> points) {
        String line = points.stream()
                .map(point -> {
                    if (point) {
                        return CONNECTED;
                    }

                    return UNCONNECTED;
                })
                .collect(Collectors.joining(DELIMITER));

        System.out.println(BLANK + DELIMITER + line + DELIMITER);
    }

    private void printResultPhrase() {
        System.out.println();
        System.out.println(RESULT);
        System.out.println();
    }
}
