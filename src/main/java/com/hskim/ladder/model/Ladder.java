package com.hskim.ladder.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Ladder {

    private LadderHeight ladderHeight;
    private LadderUsers ladderUsers;
    private List<Line> lines;

    public Ladder(LadderHeight ladderHeight, LadderUsers ladderUsers, List<Line> lines) {
        this.ladderHeight = ladderHeight;
        this.ladderUsers = ladderUsers;
        this.lines = lines;
    }

    public List<List<LadderPoint>> getAllPoints() {
        return lines.stream()
                .map(Line::getLadderPoints)
                .collect(Collectors.toList());
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
