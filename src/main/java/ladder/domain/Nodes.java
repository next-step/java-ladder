package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Nodes {
    private final List<Node> nodes;

    public Nodes(List<Node> nodes) {
        this.nodes = new ArrayList<>(nodes);
    }

    public List<Node> getNodes() {
        return Collections.unmodifiableList(nodes);
    }

    public int move(int nodeNumber) {
        return this.nodes.get(nodeNumber).move();
    }

    public Nodes addNode(Node node) {
        this.nodes.add(node);
        return new Nodes(this.nodes);
    }

    public boolean isEmpty() {
        return this.nodes.isEmpty();
    }
}
