package nextstep.ladder2.domain.player;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Players {

    private List<Player> players;

    public Players(String...names) {
        this(Arrays.stream(names)
                .map(Player::new)
                .collect(Collectors.toList()));
    }

    public Players(Player...players) {
        this(List.of(players));
    }

    public Players(List<Player> players) {
        validateDuplicate(players);

        this.players = players;
    }

    private void validateDuplicate(List<Player> players) {
        Set<Player> uniquePlayers = new HashSet<>(players);
        if (uniquePlayers.size() != players.size()) {
            throw new IllegalArgumentException("중복된 플레이어 이름이 존재합니다.");
        }
    }

    public List<Player> values() {
        return List.copyOf(players);
    }
    
    public int count() {
        return players.size();
    }

    public int indexOf(Player player) {
        return players.indexOf(player);
    }
}