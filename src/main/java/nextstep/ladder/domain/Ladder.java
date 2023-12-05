package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import nextstep.ladder.domain.lines.Lines;
import nextstep.ladder.domain.lines.position.Position;

public class Ladder {
    private final int width;
    private final Lines ladderLines;

    public Ladder(List<String> names, Lines ladderLines) {
        this.width = createWidthBy(names);
        this.ladderLines = ladderLines;
    }

    public Ladder(int width, Lines ladderLines) {
        this.width = width;
        this.ladderLines = ladderLines;
    }

    private int createWidthBy(List<String> names) {
        return names.stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);
    }

    public int getWidth() {
        return width;
    }

    public Lines getLadderLines() {
        return ladderLines;
    }

    public List<Participant> startGame(List<Participant> targetParticipants) {
        List<Participant> afterGameParticipants = new ArrayList<>();
        for (Participant target : targetParticipants) {
            Position position = this.ladderLines.startGame(target);
            afterGameParticipants.add(new Participant(target.getName(), position));
        }
        return afterGameParticipants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ladder ladder = (Ladder) o;
        return width == ladder.width && Objects.equals(ladderLines, ladder.ladderLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, ladderLines);
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "width=" + width +
                ", lines=" + ladderLines +
                '}';
    }
}
