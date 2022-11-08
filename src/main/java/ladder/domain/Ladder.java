package ladder.domain;

import java.util.Objects;

public class Ladder {

    private final Participants participants;
    private final LadderHeight height;
    private final Lines lines;

    public Ladder(final Participants participants, final LadderHeight height, final Lines lines) {
        validateOrThrow(participants, height, lines);

        this.participants = participants;
        this.height = height;
        this.lines = lines;
    }

    public Participants getParticipants() {
        return new Participants(participants);
    }

    public LadderHeight getHeight() {
        return this.height;
    }

    public Lines getLines() {
        return this.lines;
    }

    public Line getLine(final int index) {
        return this.lines.getLines()
                         .get(index);
    }

    private void validateOrThrow(final Participants participants, final LadderHeight height, final Lines lines) {
        if (Objects.isNull(participants) || Objects.isNull(height) || Objects.isNull(lines)) {
            throw new IllegalArgumentException("null인 멤버 변수를 포함할 수 없습니다.");
        }
    }
}
