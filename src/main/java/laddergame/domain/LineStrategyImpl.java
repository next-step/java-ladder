package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import laddergame.utils.RandomGenerator;

public class LineStrategyImpl implements LineStrategy {

    private static final int TARGET_NUM = 1;

    @Override
    public List<Boolean> getLine(int count) {
        List<Boolean> store = new ArrayList<>(count);

        boolean previousStatus = false;
        for (int i = 0; i < count; i++) {
            boolean isDraw = (RandomGenerator.create() == TARGET_NUM);
            isDraw = checkDuplication(previousStatus, isDraw);
            previousStatus = addDrawing(store, isDraw);
        }

        return store;
    }

    private boolean checkDuplication(final boolean previousStatus, boolean isDraw) {
        return isDuplication(previousStatus, isDraw) ? false : isDraw;
    }

    private boolean isDuplication(final boolean previousStatus, final boolean isDraw) {
        return previousStatus && isDraw;
    }

    private boolean addDrawing(final List<Boolean> store, final boolean isDraw) {
        if (isDraw) {
            store.add(true);
            return true;
        }
        store.add(false);
        return false;
    }

    @Override
    public String toString() {
        return "LineStrategyImpl{}";
    }
}
