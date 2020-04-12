package ladder.domain;

import ladder.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Line implements Cloneable {

    private final List<Node> nodes;
    private final Nodes nodes2;

    public Line() {
        this(new ArrayList<>());
    }

    public Line(final List<Node> nodes) {
        this.nodes = new ArrayList<>(nodes);
        this.nodes2 = new Nodes(nodes);
    }

    public static Line of(final int playerCount) {
        Line line = new Line();
        for (int i = 0; i < playerCount - 1; i++) {
            boolean randomBoolean = RandomUtils.getRandomBoolean();
            line = line.addRandomNextNode(randomBoolean);
        }

        line = line.addLastNode();
        return line;
    }

    public int move(int nodeNumber) {
        return nodes2.getNodes().get(nodeNumber).move();
    }

    private Line addRandomNextNode(final boolean random) {
        if (this.nodes.isEmpty()) {
            Node first = new Node(random);
            return addNode(first);
        }

        Node nextNode = getLastNode().createNextNode(random);
        return addNode(nextNode);
    }

    private Line addLastNode() {
        List<Node> merge = new ArrayList<>();
        Node last = getLastNode().createLast();
        merge.addAll(this.nodes);
        merge.add(last);
        return new Line(merge);
    }

    private Line addNode(Node node) {
        List<Node> merge = new ArrayList<>();
        merge.addAll(this.nodes);
        merge.add(node);
        return new Line(merge);
    }

    private Node getLastNode() {
        return this.nodes.get(this.nodes.size() - 1);
    }

    public List<Node> getNodes() {
        return new ArrayList<>(nodes);
    }

    public int getNoteSize() {
        return this.nodes.size();
    }

    public Node getNode(int index) {
        return nodes.get(index);
    }

    @Override
    protected Line clone() {
        List<Node> nodes = new ArrayList<>(this.nodes);
        return new Line(nodes);
    }
}
