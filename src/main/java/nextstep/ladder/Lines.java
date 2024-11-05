package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lines {
    private final static String LINES_DELIMITER = "\n";
    private List<Line> lines = new ArrayList<>();

    public Lines(int height, int countOfPerson) {
        generate(height, countOfPerson);
    }

    private void generate(int height, int countOfPerson) {
        this.lines = Stream.generate(() -> new Line(countOfPerson))
                .limit(height)
                .collect(Collectors.toList());
    }

    public List<Line> getValue() {
        return this.lines;
    }

    public String toString(String lineTrueSymbol, String lineFalseSymbol) {
        return String.join(
                LINES_DELIMITER,
                this.lines
                        .stream()
                        .map((line) -> line.toString(lineTrueSymbol, lineFalseSymbol))
                        .collect(Collectors.toList())
        );
    }
}
