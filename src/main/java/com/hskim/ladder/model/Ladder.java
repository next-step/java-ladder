package com.hskim.ladder.model;

import java.util.List;
import java.util.Objects;

public class Ladder {

    private Lines lines;
    private LadderHeight ladderHeight;
    private LadderUsers ladderUsers;

    public Ladder(LadderHeight ladderHeight, LadderUsers ladderUsers, Lines lines) {
        this.ladderHeight = ladderHeight;
        this.ladderUsers = ladderUsers;
        this.lines = lines;
    }

    private Ladder() {

    }

    public static class LadderBuilder {
        private Lines lines;
        private LadderHeight ladderHeight;
        private LadderUsers ladderUsers;

        public LadderBuilder(Lines lines) {
            this.lines = lines;
        }

        public LadderBuilder setLadderUsers(LadderUsers ladderUsers) {
            this.ladderUsers = ladderUsers;
            return this;
        }

        public LadderBuilder setLadderHeight(LadderHeight ladderHeight) {
            this.ladderHeight = ladderHeight;
            return this;
        }

        public Ladder build() {
            Ladder ladder = new Ladder();
            ladder.lines = lines;
            ladder.ladderHeight = ladderHeight;
            ladder.ladderUsers = ladderUsers;
            return ladder;
        }
    }

    public List<List<LadderPoint>> getAllPoints() {
        return lines.getLines();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ladder)) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(ladderHeight, ladder.ladderHeight) &&
                Objects.equals(ladderUsers, ladder.ladderUsers) &&
                Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderHeight, ladderUsers, lines);
    }
}
