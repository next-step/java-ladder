package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Junction {
    private boolean left;
    private boolean right;

    public boolean hasLeft() {
        return left;
    }

    public boolean hasRight() {
        return right;
    }

    public void connectRight(Junction right) {
        this.right = true;
        right.left = true;
    }

    public boolean hasConnect() {
        return this.hasLeft() || this.hasRight();
    }

    public static List<Junction> createJunctions(int size) {
        return IntStream.range(0, size)
            .mapToObj(i -> new Junction())
            .collect(Collectors.toList());
    }
}
