package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LineGenerator {
    private final Random random = new Random();
    private int userCount;

    public LineGenerator(int userCount) {
        this.userCount = userCount;
    }

    public List<Boolean> generateLine() {
        List<Boolean> lines = new ArrayList<>();
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
}
