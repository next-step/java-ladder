package nextstep.laddergame.domain.ladder.linegenerator;

import static nextstep.laddergame.domain.ladder.Line.isAllPointsFalse;
import java.util.ArrayList;
import java.util.List;
import nextstep.laddergame.util.RandomUtil;

public class RandomLineGenerator implements LineGenerator {

    private final int countOfPerson;

    public RandomLineGenerator(int countOfPerson) {
        this.countOfPerson = countOfPerson;
    }

    @Override
    public List<Boolean> lineDraw() {
        List<Boolean> points = new ArrayList<>();
        boolean previous = false;

        for (int i = 0; i < this.countOfPerson; i++) {
            boolean current = lineDecider(previous);
            points.add(current);
            previous = current;
        }
        if (isAllPointsFalse(points)) {
            points.set(chooseSomeIndex(points.size()), true);
        }
        return points;
    }

    private boolean lineDecider(boolean previous) {
        if (previous) {
            return false;
        }
        return RandomUtil.halfAndHalfBoolean();
    }

    public int chooseSomeIndex(int bound) {
        return RandomUtil.randomIndex(bound);
    }
}