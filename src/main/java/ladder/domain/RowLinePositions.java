package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RowLinePositions {
    private List<Boolean> positionList = new ArrayList<>();
    private int rowLineCount;
    private Random random = new Random();

    public RowLinePositions(int rowLineCount) {
        this.rowLineCount = rowLineCount;
        initializePositionList();
    }

    private void initializePositionList() {
        positionList.add(random.nextBoolean());
        IntStream.range(1, rowLineCount)
                 .forEach(index -> addRandomBoolean(index));
        addTrueIfAllFalse();
    }

    private void addRandomBoolean(int index) {
        if (positionList.get(index - 1)) {
            positionList.add(false);
            return;
        }
        positionList.add(random.nextBoolean());
    }

    private void addTrueIfAllFalse() {
        boolean isAllFalse = positionList.stream()
                                         .allMatch(e -> e.equals(Boolean.FALSE));
        if (isAllFalse) {
            positionList.set(random.nextInt(rowLineCount), Boolean.TRUE);
        }
    }

    public boolean isPosition(int index) {
        return positionList.get(index);
    }
}
