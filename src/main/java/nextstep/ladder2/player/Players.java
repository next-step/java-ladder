package nextstep.ladder2.player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Players {
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
                                Player.of(name, index.getAndIncrement(), names.length-1)
                        )
                );
        return group;
    }
}
