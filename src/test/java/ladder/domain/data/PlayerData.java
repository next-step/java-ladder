package ladder.domain.data;

import ladder.domain.Name;
import ladder.domain.Player;

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
