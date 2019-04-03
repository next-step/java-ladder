package ladder;

public class Player extends EndPoint {
    private final int index;
    private int destination;

    public Player(final int index, final String name) {
        super(name);
        this.index = index;
        this.destination = index;
    }

    public void descend(Ladder ladder) {
        ladder.moveLines(this);
    }

    public void movePoint(Point current) {
        if (current.isRightLinked()) {
            destination += 1;
        }
        if (current.isLeftLinked()) {
            destination -= 1;
        }
    }

    public int getDestination() {
        return destination;
    }

    public boolean equalsName(String selectedPlayer) {
        return name.equals(selectedPlayer);
    }
}
