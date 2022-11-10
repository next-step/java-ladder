package ladder.frontEnd;

import ladder.backEnd.domain.Bridge;
import ladder.backEnd.domain.Line;
import ladder.backEnd.domain.Lines;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String CONNECTION_MARK = "-".repeat(5);
    private static final String EMPTY_MARK = " ";
    private static final String NO_CONNECTION_MARK = EMPTY_MARK.repeat(5);
    private static final String LADDER_MARK = "|";
    private static final StringBuilder stringBuilder = new StringBuilder();


    public void printLadder(List<String> names, Lines lines) {
        System.out.println(assembleLadder(names, lines));
    }

    private String assembleLadder(List<String> names, Lines lines) {
        stringBuilder.append(assembleNames(names));
        stringBuilder.append(LINE_SEPARATOR);
        for (Line line : lines.getValues()) {
            stringBuilder.append(EMPTY_MARK.repeat(5));
            stringBuilder.append(LADDER_MARK);
            stringBuilder.append(assembleLine(line));
            stringBuilder.append(LADDER_MARK);
            stringBuilder.append(LINE_SEPARATOR);
        }
        return stringBuilder.toString();
    }

    private String assembleLine(Line line) {
        List<Bridge> points = line.getValue();
        return points.stream()
                .map(i -> i.isConnected() ? CONNECTION_MARK : NO_CONNECTION_MARK)
                .collect(Collectors.joining(LADDER_MARK));
    }

    private String assembleNames(List<String> names) {
        return names.stream()
                .map(i -> EMPTY_MARK.repeat(5 - i.length()) + i)
                .collect(Collectors.joining(EMPTY_MARK));
    }
}
