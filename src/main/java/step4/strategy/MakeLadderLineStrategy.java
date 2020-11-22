package step4.strategy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MakeLadderLineStrategy implements MakeLineStrategy {
    private static final Random random = new Random();
    private boolean markedPrev;

    @Override
    public List<Boolean> create(int countOfPerson) {
        markedInit();
        int lineSize = getLineSize(countOfPerson);
        return IntStream.range(0, lineSize)
                .mapToObj(value -> getRandomLine())
                .collect(Collectors.toList());
    }

    private Boolean getRandomLine() {
        markedPrev = !markedPrev && random.nextBoolean();
        return markedPrev;
    }

    private void markedInit() {
        markedPrev = false;
    }

    private int getLineSize(int countOfPerson) {
        return countOfPerson - 1;
    }
}
