package step2.domain;


import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class LadderGeneration {
    private final int size;

    public LadderGeneration(int size) {
        this.size = size;
    }

    public List<Boolean> getPoints(Condition condition) {
        Random random = new Random();

        return IntStream.range(0, size)
                .mapToObj(index -> condition.getCondition(random.nextBoolean()))
                .collect(Collectors.toList());
    }
}
