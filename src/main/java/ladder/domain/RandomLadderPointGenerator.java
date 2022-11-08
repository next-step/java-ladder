package ladder.domain;

import java.util.Random;
import java.util.function.Consumer;

public class RandomLadderPointGenerator implements LadderPointGenerator {

    @Override
    public void generate(int lineSize, int maxConnectCount, Consumer<Integer> connectLine) {
        Random random = new Random();
        for (int i = 0; i < maxConnectCount; i++) {
            int lineNumber = random.nextInt(lineSize - 1);
            connectLine.accept(lineNumber);
        }
    }
}
