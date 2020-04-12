package ladder.domain;

public class Line {

    private final Nodes nodes;

    public Line(Nodes nodes) {
        this.nodes = nodes;
    }

    public static Line of(final int playerCount) {
        Nodes nodes = Nodes.of(playerCount);
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
