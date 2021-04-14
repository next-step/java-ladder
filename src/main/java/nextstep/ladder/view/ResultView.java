package nextstep.ladder.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    private static final int NAME_LENGTH_STANDARD = 5;
    private static final String RESULT = "사다리 결과";
    private static final String DELIMITER = "|";
    private static final String CONNECTED = "-----";
    private static final String UNCONNECTED = "     ";

    public void printResultPhrase() {
        System.out.println();
        System.out.println(RESULT);
        System.out.println();
    }

    public void printNames(List<String> names) {
        convertNames(names).forEach(name -> System.out.print(name + " "));
        System.out.println();
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

    public void printLadder(List<List<Boolean>> lines) {
        lines.forEach(this::printLine);
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

        System.out.println("   " + DELIMITER + line + DELIMITER);
    }
}
