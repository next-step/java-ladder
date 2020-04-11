package ladder.domain;

public class NodeResult {
    private final Node node;
    private final String reward;

    public static NodeResult of(Node node, String reward) {
        return new NodeResult(node, reward);
    }

    private NodeResult(Node node, String reward) {
        this.node = node;
        this.reward = reward;
    }
}
