package ladder.domain.play;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {
    private final Items players;

    private Players(Items players) {
        this.players = players;
    }

    public static Players of(Items items) {
        return new Players(items);
    }

    public Item get(int index) {
        return this.players.get(index);
    }

    public List<Integer> findIndexBy(String name) {
        if (name.equals("all")) {
            return IntStream.range(0, players.size())
                    .boxed()
                    .collect(Collectors.toList());
        }

        return Arrays.asList(players.findIndexBy(name));
    }

    public int getCountOf() {
        return players.getCountOfItems();
    }

    @Override
    public String toString() {
        return players.toString();
    }
}