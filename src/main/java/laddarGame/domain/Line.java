package laddarGame.domain;

import laddarGame.dto.LineDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private final List<Boolean> line;
    private final Random random = new Random();
    private static final int ONE = 1;

    public Line(int playerCount) {
        List<Boolean> line = createLine(playerCount);
        valid(line);
        this.line = line;
    }

    public Line(List<Boolean> line) {
        valid(line);
        this.line = line;
    }

    private void valid(List<Boolean> line) {
        for (int i = 0; i < line.size() - ONE; i++) {
            isDuplicate(line.get(i), line.get(i + ONE), conditional());
        }
    }

    private void isDuplicate(boolean curPoint, boolean nextPoint, Conditional conditional) {
        boolean duplicated = conditional.test(curPoint, nextPoint);
        if (duplicated) {
            throw new IllegalArgumentException("가로라인은 두번 연속 나올 수 없습니다.");
        }
    }

    public List<Boolean> createLine(int playerCount) {
        List<Boolean> line = new ArrayList<>();
        boolean lastBoolean = false;
        for (int i = 0; i < playerCount; i++) {
            line.add(lastBoolean);
            lastBoolean = isContinuousTrue(lastBoolean, random(), conditional());
        }
        return line;
    }

    public Conditional conditional() {
        return (last, random) -> last == true && random == true;
    }

    private boolean isContinuousTrue(boolean lastBoolean, boolean randomBoolean, Conditional conditional) {
        if (conditional.test(lastBoolean, randomBoolean)) {
            return false;
        }
        return randomBoolean;
    }

    public boolean random() {
        return random.nextBoolean();
    }

    public LineDto lineDto() {
        return new LineDto(line);
    }
}

