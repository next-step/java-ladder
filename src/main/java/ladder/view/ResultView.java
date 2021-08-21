package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Name;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static final String LINE = "-----";
    public static final String LINE_BLANK = "     ";

    public void printLadder(List<Name> names, Ladder ladder) {
        names.stream()
                .forEach(name -> System.out.printf("%6s", name.getName()));
        System.out.println();
        ladder.getLadder().stream()
                .forEach(line -> printLine(line));
    }

    private void printLine(Line line) {
        String lineString = LINE_BLANK + "|" + line.getPoints().stream()
                .map(point -> draw(point))
                .collect(Collectors.joining("|")) + "|";
        System.out.println(lineString);
    }

    private String draw(Boolean point) {
        if (point) {
            return LINE;
        }
        return LINE_BLANK;
    }
}
