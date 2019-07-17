package ladder.domain;

public class Position {
    private int index;

    Position(int startPos) {
        index = startPos;
    }

    int getIndex() {
        return index;
    }

    boolean matchIndex(int index) {
        return this.index == index;
    }

    void updatePosition(int move) {
        this.index = move;
    }

    @Override
    public String toString() {
        return "index: " + index;
    }
}
