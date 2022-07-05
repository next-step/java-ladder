package nextstep.ladder.domain;

public class Edge {

    private static final String LINKED = "-----|";
    private static final String UNLINKED = "     |";

    private final boolean linked;

    public Edge() {
        this.linked = false;
    }

    public Edge(boolean linked) {
        this.linked = linked;
    }

    public Edge next(LineStrategy lineStrategy) {
        if (linked) {
            return unlink();
        }
        return new Edge(lineStrategy.isLinkable());
    }

    private Edge unlink() {
        return new Edge(false);
    }

    public String edge() {
        if (linked) {
            return LINKED;
        }
        return UNLINKED;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        return linked == edge.linked;
    }

    @Override
    public int hashCode() {
        return (linked ? 1 : 0);
    }

}
