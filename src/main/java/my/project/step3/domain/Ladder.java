package my.project.step3.domain;

import my.project.common.domain.Users;

public class Ladder {
    private final Lines lines;
    private final int height;

    public Ladder(Users users, int height) {
        this.lines = new Lines(users, height);
        this.height = height;
    }

    public Lines getLines() {
        return lines;
    }

    public int getHeight() {
        return height;
    }
}
