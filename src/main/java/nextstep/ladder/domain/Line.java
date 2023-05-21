package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private List<Boolean> points;

    public Line(int countOfPerson) {
        points = drawLine(countOfPerson);
    }

    protected List<Boolean> drawLine(int countOfPerson) {
        int ladderWeight = countOfPerson - 1;
        ArrayList<Boolean> newLine = new ArrayList<>(ladderWeight);

        newLine.add(createFirstBoolean());
        for (int i = 1; i < ladderWeight; i++) {
            newLine.add(generateBooleanWithPreviousValue(newLine.get(i - 1)));
        }
        return newLine;
    }

    private boolean createFirstBoolean() {
        return RandomBooleanGenerator.getRandomBoolean();
    }

    private boolean generateBooleanWithPreviousValue(boolean previousValue) {
        if (previousValue == Boolean.TRUE) {
            return Boolean.FALSE;
        }
        return RandomBooleanGenerator.getRandomBoolean();
    }

    public List<Boolean> toList() {
        return Collections.unmodifiableList(points);
    }
}
