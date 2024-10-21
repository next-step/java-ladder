package ladder.view;

import ladder.Line;
import ladder.Lines;
import ladder.Name;

import java.util.stream.Collectors;

public class ResultView {

    private static final String VERTICAL_LINE = "|";
    private static final String HORIZONTAL_LINE = "------";
    private static final String EMPTY_SPACE = "      ";

    public void showNames(Names names) {
        String namesLine = names.getNames()
                .stream()
                .map(Name::getName)
                .map(name -> String.format("%7s", name))
                .collect(Collectors.joining());
        System.out.println(namesLine);
    }

    public void showLines(Lines lines) {
        lines.getLines()
                .forEach(this::showLine);
    }

    private void showLine(Line line) {
        System.out.printf("%7s", VERTICAL_LINE);
        line.getPoints().stream()
                .map(isConnected -> isConnected ? HORIZONTAL_LINE + VERTICAL_LINE : EMPTY_SPACE + VERTICAL_LINE)
                .forEach(System.out::print);
        System.out.println();
    }

}
