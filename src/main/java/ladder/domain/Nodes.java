package ladder.domain;

import java.util.List;

public class Nodes {
    private final List<Node> nodes;

    public Nodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Node> getNodes() {
        return nodes;
    }
}
