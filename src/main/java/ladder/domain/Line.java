package ladder.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Line {
    private static final Random random = new Random();
    private final List<Boolean> points;

    public Line (int countOfPerson) {
        this.points = Stream.iterate(random.nextBoolean(), this::getNextLine)
                .limit(countOfPerson - 1)
                .collect(Collectors.toList());
    }

    private Boolean getNextLine(Boolean previous) {
        return !previous && random.nextBoolean();
    }

}
