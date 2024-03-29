package nextstep.ladder.dto;

import nextstep.ladder.model.Player;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class LadderResult {
    private final Map<String, String> nameAndRewardMap;

    public LadderResult(List<Player> players, List<String> reward) {
        this.nameAndRewardMap = toLinkedHashMap(players, reward);
    }

    private LinkedHashMap<String, String> toLinkedHashMap(List<Player> players, List<String> reward) {
        return players.stream()
                .collect(toMap(Player::getName, player -> reward.get(player.getPosition()), (a, b) -> a, LinkedHashMap::new));
    }

    public Map<String, String> getNameAndRewardMap() {
        return Collections.unmodifiableMap(this.nameAndRewardMap);
    }
}
