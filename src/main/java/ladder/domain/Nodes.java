package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Nodes {
    private final List<Node> nodes;

    public static Nodes of(List<Node> nodes) {
        return new Nodes(nodes);
    }

    private Nodes(List<Node> nodes) {
        this.nodes = Collections.unmodifiableList(nodes);
    }

    public void move(LadderLine ladderLine) {
        nodes.forEach(node -> node.move(position -> {
            if (ladderLine.isLinkConnect(position)) {
                return -1;
            }

            if (ladderLine.isLinkConnect(position.forward())) {
                return 1;
            }
            return 0;
        }));
    }

    public List<NodeResult> matchRewards(LadderRewards rewards) {
        return nodes.stream()
                .map(node -> NodeResult.of(node, rewards.getReward(node.getPosition())))
                .collect(Collectors.toList());
    }
}
