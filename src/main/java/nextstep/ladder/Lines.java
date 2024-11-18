package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lines {
    private final static String LINES_DELIMITER = "\n";
    private List<Line> lines = new ArrayList<>();

    public Lines(int height, int countOfPerson) {
        if (height <= 0) {
            throw new IllegalArgumentException("사다리 높이는 0 이상 입력해주세요.");
        }
        generate(height, countOfPerson);
    }

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    private void generate(int height, int countOfPerson) {
        this.lines = Stream.generate(() -> new Line(countOfPerson))
                .limit(height)
                .collect(Collectors.toList());
    }

    public List<Line> getValues() {
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

    public int getPersonFinalResultIndex(int personIndex) {
        return lines.stream()
                .reduce(personIndex, (index, line) -> line.getResultIndex(index), (a, b) -> b);
    }
}
