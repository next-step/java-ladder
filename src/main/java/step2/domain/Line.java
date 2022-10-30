package step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private static final Random random = new Random();
    public final List<Boolean> isLine;

    public Line(int userCounts) {
        this.isLine = createLadderGame(userCounts);
    }

    private List<Boolean> createLadderGame(int userCounts) {
        List<Boolean> lines = new ArrayList<>();
        for (int i = 0; i < userCounts - 1; i++) {
            lines.add(getConditional().isLine());
        }
        return lines;
    }

    private Conditional getConditional() {
        return () -> random.nextInt(2) == 1;
    }
}
