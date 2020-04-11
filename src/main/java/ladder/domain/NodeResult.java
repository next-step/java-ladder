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

    public boolean matchUser(User user) {
        return node.matchUser(user);
    }

    @Override
    public String toString() {
        String userName = node.getUser().getName();
        return userName + " : " + reward;
    }
}
