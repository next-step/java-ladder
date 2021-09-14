package nextstep.ladder2.player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Players {
    private static final Player NONE = Player.of("NONE", Integer.MAX_VALUE - 1, Integer.MAX_VALUE);
    private List<Player> players = new ArrayList<>();

    public Players(List<Player> players) {
        this.players = players;
    }

    private Players(String... names) {
        this.players = makeGroup(names);
    }

    public static Players of(String s) {
        String[] names = s.split(",");
        return new Players(names);
    }

    private List<Player> makeGroup(String[] names) {
        List<Player> group = new ArrayList<>();
        AtomicInteger index = new AtomicInteger();
        Arrays.stream(names)
                .forEach(
                        name -> group.add(
                                Player.of(name, index.getAndIncrement(), names.length - 1)
                        )
                );
        return group;
    }

    public List<String> names() {
        return players.stream()
                .map(Player::name)
                .collect(Collectors.toList());
    }

    public List<Integer> indexes() {
        return players.stream()
                .map(Player::index)
                .collect(Collectors.toList());
    }

    public void move(List<Direction> directions) {
        AtomicInteger index = new AtomicInteger();
        directions.stream()
                .forEach(dir -> {
                    players.get(index.getAndIncrement()).move(dir);
                });
    }

    public int size() {
        return this.players.size();
    }

    public int findPosition(String name) {
        return this.players.stream()
                .filter(player -> name.equals(player.name()))
                .findFirst()
                .orElse(NONE)
                .index();
    }

    public Stream<Player> stream() {
        return this.players.stream();
    }
}
