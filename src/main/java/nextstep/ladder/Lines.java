package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lines {
    private final static String LINES_DELIMITER = "\n";
    private List<Line> lines = new ArrayList<>();

    public Lines(int height, int countOfPerson) {
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

    public List<Integer> getFinalResultIndexs(int countOfPerson) {
        List<Integer> finalResultIndexs = new ArrayList<>();

        IntStream.range(0, countOfPerson)
                .forEach(personIndex -> {
                    finalResultIndexs.add(personIndex, getPersonFinalResultIndex(personIndex));
                });

        return finalResultIndexs;
    }

    private int getPersonFinalResultIndex(int personIndex) {
        return lines.stream()
                .map(Line::getResultIndexs)
                .reduce(personIndex, (index, resultIndexs) -> resultIndexs.get(index), (a, b) -> b);
    }
}
