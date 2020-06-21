package ladder.domain.data;

import ladder.domain.player.Name;
import ladder.domain.player.Player;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PlayerData {

    public static List<Player> make(int count) {
        return IntStream.range(0, count)
                .mapToObj(Integer::toString)
                .map(Name::valueOf)
                .map(Player::create)
                .collect(Collectors.toList());
    }
}
