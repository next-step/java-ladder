package ladder.domain;

import ladder.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final Nodes nodes;

    public Line() {
        this(new ArrayList<>());
    }

    public Line(final List<Node> nodes) {
        this.nodes = new Nodes(nodes);
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
        return nodes.move(nodeNumber);
    }

    private Line addRandomNextNode(final boolean random) {
        if (this.nodes.getNodes().isEmpty()) {
            Node first = new Node(random);
            return addNode(first);
        }

        Node nextNode = getLastNode().createNextNode(random);
        return addNode(nextNode);
    }

    private Line addLastNode() {
        List<Node> merge = new ArrayList<>();
        Node last = getLastNode().createLast();
        merge.addAll(this.nodes.getNodes());
        merge.add(last);
        return new Line(merge);
    }

    private Line addNode(Node node) {
        List<Node> merge = new ArrayList<>();
        merge.addAll(this.nodes.getNodes());
        merge.add(node);
        return new Line(merge);
    }

    private Node getLastNode() {
        return this.nodes.getNodes().get(this.nodes.getNodes().size() - 1);
    }

    public Nodes getNodes() {
        return nodes;
    }

    public int getNoteSize() {
        return this.nodes.getNodes().size();
    }

    public Node getNode(int index) {
        return nodes.getNodes().get(index);
    }
}
