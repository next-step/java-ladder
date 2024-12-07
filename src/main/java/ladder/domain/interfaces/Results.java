package ladder.domain.interfaces;

import ladder.domain.ns.PlayerName;
import ladder.domain.ns.RewardName;

import java.util.Map;

public interface Results {
    RewardName result(PlayerName playerName);

    Map<PlayerName, RewardName> results();
}
