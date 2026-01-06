package nextstep.laddergame;

import static nextstep.laddergame.Line.isAllPointsFalse;
import java.util.ArrayList;
import java.util.List;
import nextstep.laddergame.util.RandomUtil;

public class RandomLineGenerator implements LineGenerator {

    @Override
    public List<Boolean> lineDraw(int countOfPerson) {
        List<Boolean> points = new ArrayList<>();
        boolean previous = false;

        for (int i = 0; i < countOfPerson; i++) {
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