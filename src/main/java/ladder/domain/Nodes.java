package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Nodes {
    private final List<Node> nodes;

    public static Nodes of(List<Node> nodes) {
        return new Nodes(nodes);
    }

    private Nodes(List<Node> nodes) {
        this.nodes = Collections.unmodifiableList(nodes);
    }
}
