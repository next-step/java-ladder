package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderLine {
    private final List<Boolean> lines;

    private LadderLine(List<Boolean> lines) {
        this.lines = lines;
    }

    public static LadderLine generate(int playerCount) {
        List<Boolean> newLines = new ArrayList<>() {{
            add(randomLine(false));
        }};

        for (int i = 1; i < playerCount - 1; i++) {
            newLines.add(randomLine(newLines.get(newLines.size() - 1)));
        }

        return new LadderLine(newLines);
    }

    private static Boolean randomLine(Boolean lastLineStatus) {
        if (lastLineStatus) {
            return false;
        }
        return new Random().nextBoolean();
    }

    public List<Boolean> getLines() {
        return lines;
    }
}
