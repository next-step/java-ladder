package nextstep.ladder.domain.lines;

import java.util.List;
import java.util.Objects;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Participant;

public class Lines {

    public static final String LINES_COUNT_EXCEPTION = "줄이 1개면 사다리를 생성할 수 없습니다.";
    public static final int MIN_SIZE = 1;
    public static final String LINES_EMPTY_EXCEPTION = "lines가 존재하지 않습니다.";

    private final List<Line> lines;

    public Lines(List<Line> lines) {
        validateLines(lines);
        this.lines = lines;
    }

    private void validateLines(List<Line> lines) {
        validateEmpty(lines);
        validateLinesCount(lines);
        validateSameLength(lines);
        validateLineOverlapping(lines);
    }

    private void validateEmpty(List<Line> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException(LINES_EMPTY_EXCEPTION);
        }
    }

    private void validateLinesCount(List<Line> lines) {
        if (isMinimumSize(lines)) {
            throw new IllegalStateException(LINES_COUNT_EXCEPTION);
        }
    }

    private boolean isMinimumSize(List<Line> lines) {
        return lines.size() <= MIN_SIZE;
    }

    public void validateSameLength(List<Line> lines) {
        Line normLine = lines.get(0);
        lines.forEach(normLine::validateSameSizeAs);
    }

    public void validateLineOverlapping(List<Line> lines) {
        lines.stream()
                .skip(1)
                .reduce(lines.get(0), (targetLine, nextLine) -> {
                    targetLine.isOverlapping(nextLine);
                    return nextLine;
                });
    }

    public Participant startGame(String participantName, ParticipantPosition participantPosition) {
        if (participantPosition.isLastLine(this.lines.size())) {
            return getLadderSingleGameResult(participantName, getNotLastLinePosition());
        }
        return getLadderSingleGameResult(participantName, participantPosition);
    }

    private ParticipantPosition getNotLastLinePosition() {
        return new ParticipantPosition(this.lines.size(), 0).startAtLastLine(this.lines);
    }

    private Participant getLadderSingleGameResult(String participantName, ParticipantPosition participantPosition) {
        int position = participantPosition.startAtNormalLine(this.lines);
        return new Participant(participantName, position);
    }

    public List<Line> getLines() {
        return lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lines lines1 = (Lines) o;
        return Objects.equals(lines, lines1.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }

    @Override
    public String toString() {
        return "Lines{" +
                "lines=" + lines +
                '}';
    }
}
