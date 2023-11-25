package nextstep.step4.responsibility.domain;

import nextstep.step4.responsibility.util.RandomGenerator;

import java.util.LinkedHashMap;
import java.util.Map;

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

        Mover mover = Mover.first(RandomGenerator.nextBoolean());
        rowMovers[firstIdx] = mover;

        for (int idx = firstIdx + 1; idx < lastIdx; idx++) {
            mover = ((Mover) rowMovers[idx - 1]);
            rowMovers[idx] = mover.next(RandomGenerator.nextBoolean());
        }

        mover = ((Mover) rowMovers[lastIdx - 1]);
        rowMovers[lastIdx] = mover.last();
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
