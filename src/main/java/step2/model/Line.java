package step2.model;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Boolean> lines;

    public Line(int numberOfUser, LadderStrategy ladderStrategy) {
        lines = new ArrayList<>();

        for (int i = 0; i < numberOfUser; i++) {
            boolean isLine = ladderStrategy.generateLine();
            lines.add(isLine);
            i = exceptNext(i, isLine);
        }

    }

    private int exceptNext(int i, boolean isLine) {
        if (isLine) i += 1;
        return i;
    }

    public int getLineCount() {
        int count = 0;
        for (boolean isLine : lines) {
            if (isLine) count += 1;
        }
        return count;
    }
}
