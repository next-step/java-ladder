package step2.domain;


import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class PointsGeneration {
    private final int size;

    public PointsGeneration(int size) {
        this.size = size;
    }

    public List<Boolean> getPoints(Condition condition) {
        return IntStream.range(0, size)
                .mapToObj(index -> condition.getCondition())
                .collect(Collectors.toList());
    }
}
