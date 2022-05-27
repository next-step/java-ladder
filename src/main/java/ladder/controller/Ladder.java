package ladder.controller;

import ladder.domain.Coordinate;
import ladder.domain.Lines;
import ladder.domain.Player;

public class Ladder {
    private final Lines lines;
    private final Coordinate coordinate;

    public Ladder(Lines lines, int startX) {
        this.lines = lines;
        this.coordinate = new Coordinate(startX, 0);
    }

    public void down() {
        this.coordinate.down();
    }

    public void left() {
        this.coordinate.left();
    }

    public void right() {
        this.coordinate.right();
    }

    public Coordinate coordinate() {
        return this.coordinate;
    }

    public Boolean current() {
        return this.position(0);
    }

    public Boolean previous() {
        return this.position(-1);
    }

    public Boolean position(int offset) {
        return this.lines
                .lines()
                .get(this.coordinate.y())
                .points()
                .get(this.coordinate.x() == 0 ? 0 : this.coordinate.x() + offset);
    }

    public void play() {
        if (this.current()) {
            this.right();
            this.down();
            return;
        }
        if (this.previous()) {
            this.left();
        }
        this.down();
    }

    public Coordinate plays() {
        while(this.coordinate.y() < this.lines.lines().size()) {
            play();
        }
        return this.coordinate;
    }
}
