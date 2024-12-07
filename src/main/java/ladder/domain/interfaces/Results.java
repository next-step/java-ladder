package ladder.domain.interfaces;

import ladder.domain.wrapper.PlayerName;
import ladder.domain.wrapper.RewardName;

import java.util.Map;

public interface Results {
    RewardName result(PlayerName playerName);

    Map<PlayerName, RewardName> results();
}
