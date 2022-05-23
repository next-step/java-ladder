package ladder.domain;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Height {
    private final int height;

    public Height(int height) {
        this.height = Optional.ofNullable(height)
                .filter(h -> h <= 10)
                .orElseThrow(() -> new IllegalArgumentException("height should be less than 10 but, : " + height));
    }

    public static Height parse(String scannedHeight) {
        return new Height(Integer.parseInt(scannedHeight));
    }

    public Lines lines(int countOfPerson) {
        return new Lines(Stream.iterate(0, i -> i < this.height, i -> i + 1)
                .map(i -> new Line(countOfPerson))
                .collect(Collectors.toList()));
    }
}
