package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Node> nodes;

    public Line() {
        this(new ArrayList<>());
    }

    public Line(final List<Node> nodes) {
        this.nodes = nodes;
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
}
