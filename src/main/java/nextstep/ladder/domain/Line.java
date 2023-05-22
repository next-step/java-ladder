package nextstep.ladder.domain;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private List<Boolean> points;

    public Line(int countOfPerson) {
        if (countOfPerson < 1) {
            throw new InvalidParameterException();
        }
        if (countOfPerson == 1) {
            points = new ArrayList<>();
            return;
        }
        points = drawLine(countOfPerson);
    }

    protected List<Boolean> drawLine(int countOfPerson) {
        int ladderWeight = countOfPerson - 1;
        final List<Boolean> newLine = new ArrayList<>(ladderWeight);
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

    public int size() {
        return points.size();
    }

    public List<Boolean> toList() {
        return Collections.unmodifiableList(points);
    }
}
