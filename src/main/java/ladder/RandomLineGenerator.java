package ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLineGenerator implements LineGenerator {

    private static final Random RANDOM = new Random();

    private List<Boolean> points;

    @Override
    public List<Boolean> run(int ladderSize) {
        points = init(ladderSize);
        generateRandomHorizonLine();
        return points;
    }

    private List<Boolean> init(int ladderSize) {
        List<Boolean> booleans = new ArrayList<>(ladderSize);
        for (int i = 0; i < ladderSize; i++) {
            booleans.add(i, false);
        }
        return booleans;
    }

    private void generateRandomHorizonLine() {
        int pointSize = points.size();

        for (int index = 0; index < pointSize; index++) {
            addHorizonLine(index);
        }
    }

    private void addHorizonLine(int index) {
        if (this.verifyAddHorizon(index)) {
            points.set(index, RANDOM.nextBoolean());
        }
    }

    private boolean verifyAddHorizon(int index) {
        return isFirst(index) || isNotOverlayLine(index - 1);
    }

    private boolean isFirst(int index) {
        return index == 0;
    }

    private boolean isNotOverlayLine(int index) {
        return !points.get(index);
    }
}
