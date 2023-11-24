package nextstep.step4.responsibility.domain;

import java.util.Random;

public class Ladder implements GameRunnable {
    private final UserData userData;
    private final IndexHorizontalMover[][] indexHorizontalMovers;

    public Ladder(final UserData userData, final int height) {
        this.userData = userData;

        final int size = userData.size();
        this.indexHorizontalMovers = buildIndexHorizontalMovers(height, size);
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
            curBool = new Random().nextBoolean();

            rowMovers[idx] = buildMiddleMover(preBool, curBool);
        }

        rowMovers[lastIdx] = buildLastMover(curBool);
    }

    private IndexHorizontalMover buildFirstMover(final boolean curBool) {
        if (curBool) {
            return new RightMover();
        }

        return new NoneMover();
    }

    private IndexHorizontalMover buildMiddleMover(final boolean preBool, final boolean curBool) {
        if (preBool) {
            return new RightMover();
        }

        if (curBool) {
            return new LeftMover();
        }

        return new NoneMover();
    }

    private IndexHorizontalMover buildLastMover(final boolean curBool) {
        if (curBool) {
            return new LeftMover();
        }

        return new NoneMover();
    }

    @Override
    public GameResultProvider run() {
        return null;
    }
}
