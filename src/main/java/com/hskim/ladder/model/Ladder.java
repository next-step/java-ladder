package com.hskim.ladder.model;

import java.util.List;
import java.util.Objects;

public class Ladder {
    private static final String INVALID_STATE = "사다리가 생성되지 않아 경로를 탐색할 수 없습니다!";

    private Lines lines;
    private LadderHeight ladderHeight;

    public Ladder(LadderHeight ladderHeight, Lines lines) {
        this.ladderHeight = ladderHeight;
        this.lines = lines;
    }

    private Ladder() {

    }

    public static class LadderBuilder {
        private final Lines lines;
        private LadderHeight ladderHeight;

        public LadderBuilder(Lines lines) {
            this.lines = lines;
        }

        public LadderBuilder setLadderHeight(LadderHeight ladderHeight) {
            this.ladderHeight = ladderHeight;
            return this;
        }

        public Ladder build() {
            Ladder ladder = new Ladder();
            ladder.lines = lines;
            ladder.ladderHeight = ladderHeight;
            return ladder;
        }
    }

    public List<List<LadderPoint>> getAllPoints() {
        return lines.getLines();
    }

    public RouteInfo<Integer> getNavigateResult() {
        if (lines.isEmpty()) {
            throw new IllegalStateException(INVALID_STATE);
        }

        return RouteInfo.navigateRoutes(lines.getRouteInfoList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ladder)) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(ladderHeight, ladder.ladderHeight) &&
                Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderHeight, lines);
    }
}
