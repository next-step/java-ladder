package ladder.domain.model.strategy;

import ladder.domain.model.Player;

import java.util.List;

public interface CheckConnectStrategy {
    int getConnectResult(Player player, List<Boolean> points);

    int getLeftConnectResult(Player player, List<Boolean> points);

    int getRightConnectResult(Player player, List<Boolean> points);
}
