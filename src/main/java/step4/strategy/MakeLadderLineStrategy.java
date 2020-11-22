package step4.strategy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MakeLadderLineStrategy implements MakeLineStrategy {
    private static final List<Boolean> booleanDice = Arrays.asList(true, false);
    public static final int PICK_INDEX = 0;
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
        if (markedPrev) {
            markedPrev = false;
            return false;
        }
        shuffle();
        markedPrev = booleanDice.get(PICK_INDEX);
        return markedPrev;
    }

    private void shuffle() {
        Collections.shuffle(booleanDice);
    }

    private void markedInit() {
        markedPrev = false;
    }

    private int getLineSize(int countOfPerson) {
        return countOfPerson - 1;
    }
}
