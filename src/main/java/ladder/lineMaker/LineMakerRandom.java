package ladder.lineMaker;

import ladder.LineMaker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LineMakerRandom implements LineMaker {
    Random random;

    public LineMakerRandom() {
        this.random = new Random();
    }

    @Override
    public List<Boolean> makeLines(int lineCount) {
        List<Boolean> lines = new ArrayList<>();
        boolean pre = false;
        boolean cur;
        for (int i = 0; i < lineCount; i++) {
            if (pre){
                lines.add(false);
                pre = false;
                continue;
            }
            cur = random.nextBoolean();
            lines.add(cur);
            pre = cur;
        }
        return lines;
    }
}
