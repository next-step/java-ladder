package ladder.view;

import ladder.Bettings;
import ladder.ladder.Ladder;
import ladder.line.Line;
import ladder.name.Name;
import ladder.name.Names;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public void showLines(Ladder ladder) {
        ladder.getLines()
                .forEach(this::showLine);
    }

    private void showLine(Line line) {
        System.out.printf("%7s", VERTICAL_LINE);
        IntStream.range(0, line.getLadderPositionSize() - 1)
                .mapToObj(index -> line.hasRightConnection(index) ? HORIZONTAL_LINE + VERTICAL_LINE : EMPTY_SPACE + VERTICAL_LINE)
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
