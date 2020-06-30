package ladder.domain.play;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players extends Items {
    public static final String PLAYERS_ALL = "all";

    private Players(List<Player> items) {
        super(items);
    }

    public static Players of(List<String> names) {
        List<Player> items = names.stream()
                .map(Player::of)
                .collect(Collectors.toList());

        return new Players(items);
    }

    public List<Integer> findIndexesBy(String name) {
        if (name.equals(PLAYERS_ALL)) {
            return IntStream.range(0, this.size())
                    .boxed()
                    .collect(Collectors.toList());
        }

        return Arrays.asList(findIndexBy(name));
    }

    @Override
    void validateContains(String name) {
        if (!items.contains(Player.of(name))) {
            throw new IllegalArgumentException("유효하지 않은 값입니다.");
        }
    }

    public Player get(int index) {
        return (Player) super.items.get(index);
    }
}