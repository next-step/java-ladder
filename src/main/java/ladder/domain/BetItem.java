package ladder.domain;

public class BetItem {
    private final Name name;
    private int index;

    public BetItem(int index, String word) {
        this.index = index;
        this.name = new Name(word);
    }

    public Name getName() {
        return name;
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
