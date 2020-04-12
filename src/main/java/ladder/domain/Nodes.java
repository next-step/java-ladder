package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Nodes {
    private final List<Node> nodes;

    public Nodes() {
        this(new ArrayList<>());
    }

    public Nodes(List<Node> nodes) {
        this.nodes = new ArrayList<>(nodes);
    }

    public List<Node> getNodes() {
        return Collections.unmodifiableList(nodes);
    }

    public int move(int nodeNumber) {
        return this.nodes.get(nodeNumber).move();
    }

    public Nodes addRandomNextNode(final boolean random) {
        if (this.nodes.isEmpty()) {
            return addFirstNode(random);
        }

        Node nextNode = getLastNode().createNextNode(random);
        return addNode(nextNode);
    }

    private Nodes addFirstNode(final boolean random) {
        Node first = new Node(random);
        return addNode(first);
    }

    public Nodes addLastNode() {
        Node last = getLastNode().createLast();
        nodes.add(last);
        return new Nodes(this.nodes);
    }

    public Nodes addNode(Node node) {
        this.nodes.add(node);
        return new Nodes(this.nodes);
    }

    public boolean isEmpty() {
        return this.nodes.isEmpty();
    }

    private Node getLastNode() {
        return this.nodes.get(this.nodes.size() - 1);
    }
}
