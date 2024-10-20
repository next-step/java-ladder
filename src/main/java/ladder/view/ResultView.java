package ladder.view;

import ladder.Line;
import ladder.Lines;
import ladder.Name;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public void showNames(List<Name> names) {
        String namesLine = names.stream()
                .map(Name::getName)
                .map(name -> String.format("%7s", name))
                .collect(Collectors.joining(""));
        System.out.println(namesLine);
    }

    public void showLines(Lines lines) {
        lines.getLines()
                .forEach(this::showLine);
    }

    private void showLine(Line line) {
        System.out.printf("%7s", "|");
        line.getPoints().stream()
                .map(point -> point ? "------|" : "      |")
                .forEach(System.out::print);
        System.out.println();
    }

}
