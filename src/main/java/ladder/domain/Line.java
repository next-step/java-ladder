package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private static final int INDEX_DIFFERENCE = 1;
    private final List<Boolean> line;

    public Line(int countOfPerson) {
        this.line = new ArrayList<>();
        int lineCount = getLineCount(countOfPerson);

        for (int index = 0; index < lineCount; index++) {
            this.line.add(generateLineValue(index));
        }
    }

    private int getLineCount(int countOfPerson) {
        return countOfPerson - INDEX_DIFFERENCE;
    }

    private boolean generateLineValue(int index) {
        if (isPreviousLineExist(index)) {
            return false;
        }

        return new Random(System.currentTimeMillis()).nextBoolean();
    }

    private boolean isPreviousLineExist(int index) {
        return index != 0 && this.line.get(index - INDEX_DIFFERENCE);
    }

    public boolean isLineExist(int index) {
        return this.line.get(index);
    }
}
