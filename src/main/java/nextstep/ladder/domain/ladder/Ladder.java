package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.user.Position;

public class Ladder {

    private final Lines lines;

    public Ladder(Lines lines) {
        this.lines = lines;
    }

    public Lines getLineColumns() {
        return lines;
    }

    public int getResult(int userLocation) {
        Position position = new Position(userLocation);
        while (position.movable(lines)) {
            position.move(lines);
        }
        return position.getX();
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "lineColumns=" + lines +
                '}';
    }

}
