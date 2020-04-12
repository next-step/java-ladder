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

    public Line(Nodes nodes) {
        this.nodes = nodes;
    }

    public static Line of(final int playerCount) {
        Nodes nodes = new Nodes();
        for (int i = 0; i < playerCount - 1; i++) {
            boolean randomBoolean = RandomUtils.getRandomBoolean();
            nodes = nodes.addRandomNextNode(randomBoolean);
        }

        nodes.addLastNode();
        return new Line(nodes);
    }

    public int move(int nodeNumber) {
        return nodes.move(nodeNumber);
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
