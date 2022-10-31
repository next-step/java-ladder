package step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private static final Random random = new Random();
    public final List<Boolean> hasLine;

    public Line(int userCounts) {
        this.hasLine = createLadderLine(userCounts);
    }

    private List<Boolean> createLadderLine(int userCounts) {
        List<Boolean> lines = new ArrayList<>();
        for (int i = 0; i < userCounts - 1; i++) {
            lines.add(canHaveLine(lines, i));
        }
        return lines;
    }

    private boolean canHaveLine(List<Boolean> lines, int i) {
        if (i > 0 && lines.get(i - 1) == true) {
            return false;
        }
        return getConditional().isLine();
    }

    private Conditional getConditional() {
        return () -> random.nextInt(2) == 1;
    }
}
