package ladder.domain;

import java.util.List;

public class Line {

    private final List<Node> nodes;

    public Line(final List<Node> nodes) {
        this.nodes = nodes;
    }

    public int size() {
        return this.nodes.size();
    }
}
