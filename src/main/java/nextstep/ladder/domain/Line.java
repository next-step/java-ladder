package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private static final RandomLineStrategy RANDOM_LINE_STRATEGY = new RandomLineStrategy();

    private final List<Edge> edges;

    public Line(int numberOfParticipants) {
        this.edges = new ArrayList<>();

        Edge edge = new Edge();
        for (int i = 1; i < numberOfParticipants; i++) {
            edge = edge.next(RANDOM_LINE_STRATEGY);
            this.edges.add(edge);
        }
    }

    public String toLadderLine() {
        StringBuilder line = new StringBuilder("    |");
        for (Edge edge : this.edges) {
            line.append(edge.link());
        }

        return line.toString();
    }

    public List<Edge> points() {
        return edges;
    }
}
