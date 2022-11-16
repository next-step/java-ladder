package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Line {
    private final List<Boolean> connects = new ArrayList<>();
    public Line(final PlayerCount playerCount, final Supplier<Boolean> linePredicate) {
        final int count = playerCount.count() - 1;
        for (int i = 0; i < count; i++) {
            connects.add(connectable(i, linePredicate));
        }
    }

    public List<Boolean> connects() {
        return connects;
    }

    private boolean connectable(final int index, final Supplier<Boolean> linePredicate) {
        if(index != 0 && connects.get(index-1)) {
            return false;
        }

        return linePredicate.get();
    }
}
