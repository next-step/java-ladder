package laddergame.domain.line;

import static laddergame.domain.line.LineStatus.CONNECTION;
import static laddergame.domain.line.LineStatus.DETACHMENT;

import java.util.ArrayList;
import java.util.List;
import laddergame.utils.RandomGenerator;

public class Connection implements ConnectionStrategy {

    @Override
    public List<LineStatus> getConnection(int count) {
        List<LineStatus> store = new ArrayList<>(count);

        LineStatus previousStatus = DETACHMENT;

        for (int i = 0; i < count; i++) {
            LineStatus isConnected = LineStatus.of(RandomGenerator.create());
            previousStatus = addConnection(store, checkDuplication(previousStatus, isConnected));
        }
        return store;
    }

    private LineStatus checkDuplication(final LineStatus previousStatus, LineStatus isConnected) {
        return isDuplication(previousStatus, isConnected) ? DETACHMENT : isConnected;
    }

    private boolean isDuplication(final LineStatus previousStatus, final LineStatus isConnected) {
        return previousStatus == isConnected;
    }

    private LineStatus addConnection(final List<LineStatus> store, final LineStatus isConnected) {
        if (isConnected == CONNECTION) {
            store.add(CONNECTION);
            return CONNECTION;
        }
        store.add(DETACHMENT);
        return DETACHMENT;
    }
}
