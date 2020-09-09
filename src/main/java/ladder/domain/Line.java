package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private Random random = new Random();
    private List<Boolean> lines = new ArrayList<>();

    public Line(int userCount) {
        generateLine(userCount);
    }

    private List<Boolean> generateLine(int userCount) {
        lines.add(Boolean.FALSE);
        for(int i = 1; i < userCount; i++) {
            boolean prevLine = lines.get(i - 1);
            lines.add(randomLine(prevLine));
        }
        return lines;
    }

    private Boolean randomLine(Boolean existLine) {
        if(existLine) {
            return Boolean.FALSE;
        }
        return random.nextBoolean();
    }

    public List<Boolean> getLine() {
        return lines;
    }
}
