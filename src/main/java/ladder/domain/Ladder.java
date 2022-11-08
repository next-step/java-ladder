package ladder.domain;

import java.util.Objects;
import java.util.stream.IntStream;

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
        return this.lines.height();
    }

    public Lines getLines() {
        return this.lines;
    }

    public Line getLine(final int index) {
        return this.lines.getLines()
                         .get(index);
    }

    public int getLastVerticalLineIndex(final Participant participant) {
        return this.getLastVerticalLineIndex(this.participants.indexOf(participant));
    }

    private int getLastVerticalLineIndex(final int firstVerticalLineIndex) {
        return IntStream.range(0, this.lines.height())
                        .reduce(firstVerticalLineIndex, (curVerticalLineIndex, curLineHeight) -> {
                            if (canMoveLeft(curVerticalLineIndex, curLineHeight)) {
                                return curVerticalLineIndex - 1;
                            }

                            if (canMoveRight(curVerticalLineIndex, curLineHeight)) {
                                return curVerticalLineIndex + 1;
                            }

                            return curVerticalLineIndex;
                        });
    }

    private boolean canMoveLeft(final int verticalLineIndex, final int curLineHeight) {
        if (isFirstVerticalLineIndex(verticalLineIndex)) {
            return false;
        }

        return this.lines.getLine(curLineHeight)
                         .isConnected(verticalLineIndex - 1);
    }

    private boolean canMoveRight(final int verticalLineIndex, final int curLineHeight) {
        if (isLastVerticalLineIndex(verticalLineIndex)) {
            return false;
        }

        return this.lines.getLine(curLineHeight)
                         .isConnected(verticalLineIndex);
    }


    private boolean isFirstVerticalLineIndex(final int verticalLineIndex) {
        return verticalLineIndex == 0;
    }


    private boolean isLastVerticalLineIndex(final int verticalLineIndex) {
        return verticalLineIndex == this.lines.width();
    }

    private void validateOrThrow(final Participants participants, final Lines lines) {
        if (Objects.isNull(participants) || Objects.isNull(lines)) {
            throw new IllegalArgumentException("참가자나 사다리 라인은 null이 될 수 없습니다.");
        }
    }
}
