package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Line {

    private List<Boolean> lines = new ArrayList<Boolean>();
    private final static Random random = new Random();

    public Line(int size) {

        for (int index = 0; index < size; index++) {
            lines.add(random.nextBoolean());
        }
    }

    public List<Boolean> getLines() {
        return lines;
    }
}
