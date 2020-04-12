package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Node> nodes;

    private Line(final List<Node> nodes) {
        this.nodes = new ArrayList<>(nodes);
    }

    public static Line of(final int playerCount, final LadderMoveStrategy strategy) {
        List<Node> nodes = new ArrayList<>();
        Node node = new Node(strategy);
        nodes.add(node);

        for (int i = 1; i < playerCount - 1; i++) {
            node = node.createNextNode(strategy);
            nodes.add(node);
        }

        node = node.createLast();
        nodes.add(node);
        return new Line(nodes);
    }

    public int move(final int nodeNumber) {
        return nodes.get(nodeNumber).move();
    }

    public List<Node> getNodes() {
        return nodes;
    }
}
