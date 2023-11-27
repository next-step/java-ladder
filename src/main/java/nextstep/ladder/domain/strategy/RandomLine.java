package nextstep.ladder.domain.strategy;

import nextstep.ladder.domain.Line;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLine implements LineStrategy {
    private static final int SECOND_LINE_INDEX = 1;
    private static final int THIRD_LINE_INDEX = 2;

    @Override
    public Line createLine(int personCount) {
        int lineCount = personCount - 1;
        List<Boolean> list = new ArrayList<>();
        boolean twoLeftPositionHasLine = false;
        boolean oneLeftPositionHasLine = false;
        for (int index = 0; index < lineCount; index++) {
            if (index >= SECOND_LINE_INDEX) {
                oneLeftPositionHasLine = list.get(index - 1);
                if(oneLeftPositionHasLine) {
                    list.add(Boolean.FALSE);
                    continue;
                }
            }

            if (index >= THIRD_LINE_INDEX) {
                twoLeftPositionHasLine = list.get(index - 2);
                oneLeftPositionHasLine = list.get(index - 1);
                if(!twoLeftPositionHasLine && !oneLeftPositionHasLine) {
                    list.add(Boolean.TRUE);
                    continue;
                }
            }

            list.add(new Random().nextBoolean());
        }

        return new Line(list);
    }
}
