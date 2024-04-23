package nextstep.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lines {
    List<Line> lines = new ArrayList<>();
    public static Random RANDOM = new Random();

    public static Lines create(int countOfPerson, int height) {
        return new Lines(Stream.generate(() -> new Line(countOfPerson, isFirst()))
                .limit(height)
                .collect(Collectors.toUnmodifiableList()));
    }

    private static boolean isFirst() {
        return RANDOM.nextInt(2) == 1;
    }

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public Integer size() {
        return lines.size();
    }

    public List<String> getLines() {
        return lines.stream().map(Line::getLineString).collect(Collectors.toUnmodifiableList());
    }
}
