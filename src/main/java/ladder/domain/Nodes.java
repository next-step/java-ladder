package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Nodes {
    private final List<Node> nodes;

    public Nodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Node> getNodes() {
        return Collections.unmodifiableList(nodes);
    }

    public int move(int nodeNumber) {
        return this.nodes.get(nodeNumber).move();
    }
}
