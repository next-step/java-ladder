package nextstep.step4.responsibility.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class Ladder implements GameRunnable {
    private final UserData userData;
    private final IndexHorizontalMover[][] indexHorizontalMovers;

    public Ladder(final UserData userData, final int height) {
        this.userData = userData;

        final int size = userData.size();
        this.indexHorizontalMovers = buildIndexHorizontalMovers(height, size);
    }

    public Ladder(final UserData userData, final IndexHorizontalMover[][] movers) {
        this.userData = userData;
        this.indexHorizontalMovers = movers;
    }

    private IndexHorizontalMover[][] buildIndexHorizontalMovers(final int height, final int size) {
        final IndexHorizontalMover[][] tempMovers = new IndexHorizontalMover[height][size];

        for (int row = 0; row < height; row++) {
            tempMovers[row] = buildRowHorizontalMover(size);
        }

        return tempMovers;
    }

    private IndexHorizontalMover[] buildRowHorizontalMover(final int size) {
        final IndexHorizontalMover[] rowMovers = new IndexHorizontalMover[size];

        initRowMovers(rowMovers);

        return rowMovers;
    }

    private void initRowMovers(final IndexHorizontalMover[] rowMovers) {
        final int firstIdx = 0;
        final int lastIdx = rowMovers.length - 1;
        boolean curBool = new Random().nextBoolean();

        rowMovers[firstIdx] = buildFirstMover(curBool);

        for (int idx = firstIdx + 1; idx < lastIdx; idx++) {
            boolean preBool = curBool;
            curBool = adjustConsequtiveTrue(preBool);

            rowMovers[idx] = buildMiddleMover(preBool, curBool);
        }

        rowMovers[lastIdx] = buildLastMover(curBool);
    }

    private boolean adjustConsequtiveTrue(final boolean preBool) {
        if (preBool) {
            return false;
        }

        return new Random().nextBoolean();
    }

    private IndexHorizontalMover buildFirstMover(final boolean curBool) {
        if (curBool) {
            return Mover.RIGHT;
        }

        return Mover.NONE;
    }

    private IndexHorizontalMover buildMiddleMover(final boolean preBool, final boolean curBool) {
        if (preBool) {
            return Mover.LEFT;
        }

        if (curBool) {
            return Mover.RIGHT;
        }

        return Mover.NONE;
    }

    private IndexHorizontalMover buildLastMover(final boolean curBool) {
        if (curBool) {
            return Mover.LEFT;
        }

        return Mover.NONE;
    }

    @Override
    public GameResultProvider run() {
        Map<String, String> result = new LinkedHashMap<>();

        for (int userIdx = 0; userIdx < userNamesSize(); userIdx++) {
            final int arrivalIdx = move(userIdx);

            result.put(userNames().get(userIdx), userResults().get(arrivalIdx));
        }

        return new LadderResult(result);
    }

    private int userNamesSize() {
        return this.userData.size();
    }

    private int move(final int userIdx) {
        int arrivalIdx = userIdx;

        for (final IndexHorizontalMover[] rowMovers : this.indexHorizontalMovers) {
            final IndexHorizontalMover mover = rowMovers[arrivalIdx];

            arrivalIdx = mover.moveHorizontal(arrivalIdx);
        }

        return arrivalIdx;
    }

    public UserInputProvider userNames() {
        return this.userData.getUserNames();
    }

    public UserInputProvider userResults() {
        return this.userData.getUserResults();
    }

    public IndexHorizontalMover[][] indexHorizontalMovers() {
        return this.indexHorizontalMovers;
    }
}
