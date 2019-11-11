package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomGenerator {

    private static final int FIRST_INDEX = 0;

    public static List<Line> createRandomLine(List<Line> lines, int height) {
        List<Line> randomLines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            Collections.shuffle(lines);
            randomLines.add(lines.get(FIRST_INDEX));
        }
        return randomLines;
    }

}
