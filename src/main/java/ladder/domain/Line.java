package ladder.domain;

import ladder.utils.RandomUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line implements Cloneable {

    private final List<Node> nodes;

    public Line() {
        this(new ArrayList<>());
    }

    public Line(final List<Node> nodes) {
        this.nodes = Collections.unmodifiableList(nodes);
    }

    public static Line of(int playerCount) {
        Line line = new Line();
        for (int i = 0; i < playerCount - 1; i++) {
            boolean randomBoolean = RandomUtils.getRandomBoolean();
            line = line.addRandomNextNode(randomBoolean);
        }

        line = line.addLastNode();
        return line;
    }

    public Line addRandomNextNode(final boolean random) {
        if (this.nodes.isEmpty()) {
            Node first = Node.createFirst(random);
            return addNode(first);
        }

        Node nextNode = getLastNode().createNextNode(random);
        return addNode(nextNode);
    }

    public Line addLastNode() {
        List<Node> merge = new ArrayList<>();
        Node last = getLastNode().createLast();
        merge.addAll(this.nodes);
        merge.add(last);
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

    public List<Node> getNodes() {
        return new ArrayList<>(this.nodes);
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
