package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class RandomLine implements LineStrategy {
    private static final int SECOND_LINE_INDEX = 1;
    private static final int THIRD_LINE_INDEX = 2;

    @Override
    public Line createLine(int personCount) {
        List<Boolean> list = new ArrayList<>();
        boolean twoLeftPositionHasLine = false;
        boolean oneLeftPositionHasLine = false;
        for (int index = 0; index < personCount; index++) {
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

            list.add(randomLine());
        }

        return new Line(list);
    }

    private static boolean randomLine() {
        int min = 1;
        int max = 2;
        int randomValue = (int) (Math.random() * max) + min;

        return randomValue == 1 ? Boolean.TRUE : Boolean.FALSE;
    }
}
