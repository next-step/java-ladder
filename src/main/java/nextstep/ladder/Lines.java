package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lines {
    private List<Line> lines = new ArrayList<>();

    public Lines(int height, int countOfPerson) {
        generate(height, countOfPerson);
    }

    private void generate(int height, int countOfPerson){
        this.lines = Stream.generate(() -> new Line(countOfPerson))
                .limit(height)
                .collect(Collectors.toList());
    }

    public String toString(String delimiter, String lineDelimiter, String lineTrueSymbol, String lineFalseSymbol) {
        return String.join(
                delimiter,
                this.lines
                        .stream()
                        .map((line) -> line.toString(lineDelimiter, lineTrueSymbol, lineFalseSymbol))
                        .collect(Collectors.toList())
        );
    }
}
