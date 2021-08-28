package step2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        return (int) lines.stream()
                .filter(line -> line)
                .count();
    }

    public List<Boolean> getLine() {
        return lines;
    }
}
