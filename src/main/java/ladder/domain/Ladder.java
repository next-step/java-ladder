package ladder.domain;

import java.util.Objects;

public class Ladder {

    private final Participants participants;
    private final Lines lines;

    public Ladder(final Participants participants, final Lines lines) {
        validateOrThrow(participants, lines);

        this.participants = participants;
        this.lines = lines;
    }

    public Participants getParticipants() {
        return new Participants(participants);
    }

    public int getHeight() {
        return this.lines.size();
    }

    public Lines getLines() {
        return this.lines;
    }

    public Line getLine(final int index) {
        return this.lines.getLines()
                         .get(index);
    }

    private void validateOrThrow(final Participants participants, final Lines lines) {
        if (Objects.isNull(participants) || Objects.isNull(lines)) {
            throw new IllegalArgumentException("참가자나 사다리 라인은 null이 될 수 없습니다.");
        }
    }
}
