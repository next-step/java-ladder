package laddergame.domain.ladder;

import laddergame.domain.Players;

public class Size {
    private final Height height;
    private final Width width;

    public Size(Height height, Width width) {
        this.height = height;
        this.width = width;
    }

    public Size(int height, int width) {
        this.height = new Height(height);
        this.width = new Width(width);
    }

    public static Size calculate(int height, Players players) {
        return new Size(new Height(height), new Width(players.count()));
    }

    public int height() {
        return height.getHeight();
    }

    public int width() {
        return width.getWidth();
    }
}
