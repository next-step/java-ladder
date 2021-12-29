package rick.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Players {

    private static final String EXCEPTION_MESSAGE_CAN_NOT_BE_NULL = "이름 목록이 null 일 수 없습니다.";
    private static final String EXCEPTION_MESSAGE_CAN_NOT_BE_EMPTY = "이름 목록이 비어 있습니다.";

    private final List<Player> players;

    public Players(List<String> names) {
        if (Objects.isNull(names)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_CAN_NOT_BE_NULL);
        }

        if (names.isEmpty()) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_CAN_NOT_BE_EMPTY);
        }

        players = names.stream()
            .map(Player::new)
            .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int playerCount() {
        return players.size();
    }

    public Player player(String name) {
        Player player = new Player(name);

        return players.stream()
            .filter(player::equals)
            .findFirst()
            .orElse(null);
    }

    public Reward reward(Ladder ladder, Rewards rewards, Player player) {
        int playerIndex = players.indexOf(player);
        int rewardIndex = ladder.rewardIndex(playerIndex);
        return rewards.reward(rewardIndex);
    }
}
