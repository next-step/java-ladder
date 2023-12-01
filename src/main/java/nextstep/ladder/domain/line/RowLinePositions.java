package nextstep.ladder.domain.line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RowLinePositions {
    private List<Boolean> positionList = new ArrayList<>();
    private int rowLineCount;
    private static final Random random = new Random();

    public RowLinePositions(List<Boolean> positionList, int rowLineCount) {
        this.positionList = positionList;
        this.rowLineCount = rowLineCount;
    }

    public static RowLinePositions create(int rowLineCount) {
        List<Boolean> positionList = new ArrayList<>();
        initializePositionList(positionList, rowLineCount);
        return new RowLinePositions(positionList, rowLineCount);
    }

    private static void initializePositionList(List<Boolean> positionList, int rowLineCount) {
        positionList.add(random.nextBoolean());
        IntStream.range(1, rowLineCount)
                .forEach(index -> addRandomBoolean(positionList, index));
        addTrueIfAllFalse(positionList, rowLineCount);
    }

    private static void addRandomBoolean(List<Boolean> positionList, int index) {
        if (positionList.get(index - 1)) {
            positionList.add(false);
            return;
        }
        positionList.add(random.nextBoolean());
    }

    private static void addTrueIfAllFalse(List<Boolean> positionList, int rowLineCount) {
        boolean isAllFalse = positionList.stream()
                .allMatch(e -> e.equals(Boolean.FALSE));
        if (isAllFalse) {
            positionList.set(random.nextInt(rowLineCount), Boolean.TRUE);
        }
    }

    public boolean isTrue(int index) {
        return positionList.get(index);
    }

    public final List<Boolean> getPositionList() {
        return Collections.unmodifiableList(positionList);
    }
}
