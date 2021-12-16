package ladder.domain;

import ladder.strategy.MovingStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Floor> floors;

    public Ladder(int height, int countOfPillar, MovingStrategy movingStrategy) {
        this.floors = IntStream.range(0, height)
                .mapToObj(i -> new Floor(countOfPillar, movingStrategy))
                .collect(Collectors.toList());
    }

    public List<Floor> getFloors() {
        return Collections.unmodifiableList(this.floors);
    }
}
