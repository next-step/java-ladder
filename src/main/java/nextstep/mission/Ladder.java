package nextstep.mission;

import java.util.Objects;

public class Ladder {

    private Participants participants;
    private Lines lines;

    private Ladder(Participants participants, int height) {
        this.participants = participants;
        this.lines = new Lines(participants.size(), height);
    }

    public static Ladder make(Participants participants, int height) {
        return new Ladder(participants, height);
    }

    public int getHeight() {
        return this.lines.getHeight();
    }

    public Line getLine(int index) {
        if (this.lines.getHeight() - 1 < index) {
            return null;
        }

        return this.lines.getLine(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(participants, ladder.participants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participants);
    }

}
