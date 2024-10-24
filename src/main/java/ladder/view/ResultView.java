package ladder.view;

import ladder.Bettings;
import ladder.line.Line;
import ladder.line.Lines;
import ladder.name.Name;
import ladder.name.Names;

import java.util.Map;
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


    public void showBettings(Bettings bettings) {
        String namesLine = bettings.getBettings()
                .stream()
                .map(name -> String.format("%7s", name))
                .collect(Collectors.joining());
        System.out.println(namesLine);
    }

    public void showBettingResult(Map<String, String> ladderResult) {
        System.out.println();
        System.out.println("실행결과");
        ladderResult.forEach((key, value) -> System.out.printf("%s: %s%n", key, value));

    }

}
