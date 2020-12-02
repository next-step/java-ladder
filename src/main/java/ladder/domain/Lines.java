package ladder.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {

    private final static Random RANDOM = new Random();

    private final List<Line> lines;

    private Lines(List<Line> lines) {
        this.lines = lines;
    }

    public static Lines of(int countOfPerson) {
        return new Lines(addLines(countOfPerson));
    }

    public static Boolean isLine() {
        return RANDOM.nextBoolean();
    }

    private static List<Line> addLines(int countOfPerson) {
        return IntStream.range(0, countOfPerson)
                .mapToObj(i -> Line.of(isLine()))
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return this.lines;
    }
}
