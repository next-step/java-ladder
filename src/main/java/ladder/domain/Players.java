package ladder.domain;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {
    private final List<Player> players;

    private Players(String words) {
        this.players = parse(words);
    }

    public static Players valueOfComma(String words) {
        return new Players(words);
    }

    private List<Player> parse(String words) {
        String[] names = words.split(",");
        return IntStream.range(0, names.length)
                .mapToObj(i -> new Player(i, names[i]))
                .collect(Collectors.toList());
    }

    public Player get(int i) {
        return players.get(i);
    }

    public int getCount() {
        return players.size();
    }

    public boolean isEqualCount(BetItems betItems) {
        return players.size() == betItems.getCount();
    }

    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public String toString() {
        return Name.BLANK + String.join(Name.BLANK,
                players.stream()
                        .map(Player::toString)
                        .collect(Collectors.toList()));
    }
}
