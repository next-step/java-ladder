package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Junction {
    private Junction left;
    private Junction right;

    public boolean hasLeft() {
        return left != null;
    }

    public boolean hasRight() {
        return right != null;
    }

    public void connectRight(Junction right) {
        this.right = right;
        right.left = this;
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
