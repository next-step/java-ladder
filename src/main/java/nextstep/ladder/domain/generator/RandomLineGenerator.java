package nextstep.ladder.domain.generator;

import java.util.concurrent.ThreadLocalRandom;

public class RandomLineGenerator implements LineGenerator {
    private final static ThreadLocalRandom random = ThreadLocalRandom.current();

    @Override
    public boolean[] lineGenerate(int lineLength) {
        boolean[] line = new boolean[lineLength];
        for (int i = 0; i < lineLength; i++) {
            toValidConnect(line, i);
        }
        return line;
    }

    private void toValidConnect(boolean[] line, int idx) {
        if (idx == 0) {
            line[idx] = pointGenerate();
            return;
        }

        if (line[idx - 1] != true) {
            line[idx] = pointGenerate();
            return;
        }
    }

    public boolean pointGenerate() {
        return random.nextBoolean();
    }
}
