package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Line {

    private final List<Boolean> exists;

    public Line(List<Boolean> exists) {
        this.exists = exists;
    }

    public static Line of(int height) {
        List<Boolean> exists = Stream
            .generate(() -> LineExistsGenerator.generate(false))
            .limit(height)
            .collect(Collectors.toList());

        return new Line(exists);
    }

    public static Line of(Line prev) {
        return new Line(prev.exists.stream()
            .map(LineExistsGenerator::generate)
            .collect(Collectors.toList()));
    }

    public int size() {
        return exists.size();
    }

    public boolean lineExists(int index) {
        return exists.get(index);
    }

    public List<Boolean> getExists() {
        return exists;
    }
}
