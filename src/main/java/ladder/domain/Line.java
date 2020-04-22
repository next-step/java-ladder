package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Boolean> line;

    public Line(int countOfPerson) {
        this.line = new ArrayList<>();
        int lineCount = getLineCount(countOfPerson);

        for (int index = 0; index < lineCount; index++) {
            line.add(generateLineValue(index));
        }
    }

    private int getLineCount(int countOfPerson) {
        return countOfPerson - 1;
    }

    private boolean generateLineValue(int index) {
        if (index != 0 && line.get(index - 1)) {
            return false;
        }

        return new Random(System.currentTimeMillis()).nextBoolean();
    }

    public boolean isLineExist(int index) {
        return line.get(index);
    }
}
