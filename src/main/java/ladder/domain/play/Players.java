package ladder.domain.play;

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

    public int getCountOf() {
        return players.getCountOfItems();
    }

    @Override
    public String toString() {
        return players.toString();
    }
}