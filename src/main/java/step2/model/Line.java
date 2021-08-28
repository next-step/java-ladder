package step2.model;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Boolean> lines;

    public Line(int numberOfUser, LadderStrategy ladderStrategy) {
        lines = new ArrayList<>();

        for (int i = 0; i < numberOfUser - 1; i++) {
            if (i != 0 && lines.get(lines.size() - 1)) {
                lines.add(false);
                continue;
            }
            boolean drawLine = ladderStrategy.generateLine();
            lines.add(drawLine);
        }

    }

    public int getLineCount() {
        int count = 0;
        for (boolean isLine : lines) {
            if (isLine) count += 1;
        }
        return count;
    }

    public List<Boolean> getLine() {
        return lines;
    }
}
