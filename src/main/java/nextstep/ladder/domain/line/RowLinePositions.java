package nextstep.ladder.domain.line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RowLinePositions {
    private List<Boolean> positionList = new ArrayList<>();
    private int rowLineNumber;
    private static final Random random = new Random();

    public RowLinePositions(List<Boolean> positionList, int rowLineNumber) {
        this.positionList = positionList;
        this.rowLineNumber = rowLineNumber;
    }

    public static RowLinePositions create(int rowLineNumber) {
        List<Boolean> positionList = new ArrayList<>();
        initializePositionList(positionList, rowLineNumber);
        return new RowLinePositions(positionList, rowLineNumber);
    }

    private static void initializePositionList(List<Boolean> positionList, int rowLineNumber) {
        positionList.add(random.nextBoolean());
        IntStream.range(1, rowLineNumber)
                .forEach(index -> addRandomBoolean(positionList, index));
        addTrueIfAllFalse(positionList, rowLineNumber);
    }

    private static void addRandomBoolean(List<Boolean> positionList, int index) {
        if (positionList.get(index - 1)) {
            positionList.add(false);
            return;
        }
        positionList.add(random.nextBoolean());
    }

    private static void addTrueIfAllFalse(List<Boolean> positionList, int rowLineNumber) {
        boolean isAllFalse = positionList.stream()
                .allMatch(e -> e.equals(Boolean.FALSE));
        if (isAllFalse) {
            positionList.set(random.nextInt(rowLineNumber), Boolean.TRUE);
        }
    }

    public boolean isTrue(int index) {
        return positionList.get(index);
    }

    public final List<Boolean> getPositionList() {
        return Collections.unmodifiableList(positionList);
    }
}
