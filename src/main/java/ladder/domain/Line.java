package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line implements Cloneable {

    private final List<Node> nodes;

    public Line() {
        this(new ArrayList<>());
    }

    public Line(final List<Node> nodes) {
        this.nodes = nodes;
    }

    public Line addRandomNextNode(final boolean random) {
        List<Node> merge = new ArrayList<>();

        if (this.nodes.isEmpty()) {
            merge.add(Node.createFirst(random));
            return new Line(merge);
        }

        Node nextNode = getLastNode().createNextNode(random);
        merge.addAll(this.nodes);
        merge.add(nextNode);
        return new Line(merge);
    }

    public Line addNode(Node node) {
        List<Node> merge = new ArrayList<>();
        merge.addAll(this.nodes);
        merge.add(node);
        return new Line(merge);
    }

    public int size() {
        return this.nodes.size();
    }

    private Node getLastNode() {
        return this.nodes.get(nodes.size() - 1);
    }

    public Node getNode(int index) {
        return this.nodes.get(index);
    }

    @Override
    protected Line clone() {
        List<Node> nodes = new ArrayList<>(this.nodes);
        return new Line(nodes);
    }
}
