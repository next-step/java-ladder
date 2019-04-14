package ladder.domain;

public class Player {
    private final Name name;
    private final int index;

    public Player(int index, String word) {
        this.index = index;
        this.name = new Name(word);
    }

    public Name getName() {
        return name;
    }

    public boolean isEqualName(String selectedPlayer) {
        return name.isEqual(selectedPlayer);
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
