package laddarGame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    private List<Boolean> line;
    private final Random random = new Random();

    public Line(int playerCount) {
        List<Boolean> line = createLine(playerCount);
        valid(line);
    }

    public Line(List<Boolean> line) {
        valid(line);
        this.line = line;
    }

    private void valid(List<Boolean> line) {
        for (int i = 0; i < line.size() - 1; i++) {
            isDuplicate(line.get(i), line.get(i + 1), conditional());
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
        boolean lastBoolean = true;
        for (int i = 0; i < playerCount; i++) {
            boolean randomBoolean = random();
            lastBoolean = addLine(lastBoolean, randomBoolean, conditional());
            line.add(lastBoolean);
        }
        return line;
    }

    public Conditional conditional() {
        return (last, random) -> last == true && random == true;
    }

    private boolean addLine(boolean lastBoolean, boolean randomBoolean, Conditional conditional) {
        if (conditional.test(lastBoolean, randomBoolean)) {
            return false;
        }
        return randomBoolean;
    }

    public boolean random() {
        return random.nextBoolean();
    }
}

