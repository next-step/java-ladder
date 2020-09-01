package nextstep.mission.domain;

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

    public boolean checkHeight(int height) {
        return this.lines.checkHeight(height);
    }

    public Line getLine(int index) {
        return this.lines.getLine(index);
    }

    public int getResult(String name) {
        return lines.getResultPosition(participants.getPosition(name));
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
