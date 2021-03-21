package ladder.domain;

import java.util.List;
import java.util.Objects;

public class Player {

    private final Name name;

    private LadderNumber ladderNumber;

    public Player(String name,int ladderNumber) {
        this(new Name(name), new LadderNumber(ladderNumber));
    }

    public Player(Name name,LadderNumber ladderNumber) {
        this.name = name;
        this.ladderNumber = ladderNumber;
    }

    public String name() {
        return name.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public void move(LineList lineList) {
        List<Line> list = lineList.lineList();
        for (Line line : list) {
            moveBy(line);
        }
    }

    private void moveRight() {
        ladderNumber = ladderNumber.sum(1);
    }

    private void moveLeft() {
        ladderNumber = ladderNumber.sum(-1);
    }

    public void moveBy(Line line) {
        int leftPointIndex = ladderNumber.number();
        if (line.isFilledAt(leftPointIndex)) {
            moveLeft();
        }
        int rightPointIndex = ladderNumber.number() + 1;
        if (line.isFilledAt(rightPointIndex)) {
            moveRight();
        }
    }

    public LadderNumber ladderNumber() {
        return ladderNumber;
    }
}
