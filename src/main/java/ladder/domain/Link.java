package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Link {
    private final int index;
    private final boolean linked;

    public Link(int index, boolean linked) {
        this.index = index;
        this.linked = linked;
    }

    public boolean isLinked() {
        return linked;
    }

    public void swapPosition(List<Integer> positions) {
        if (linked) {
            Collections.swap(positions, index - 1, index);
        }
    }
}
