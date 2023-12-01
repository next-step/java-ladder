package nextstep.ladder.domain.line;

public class Line {
    private RowLinePositions rowLinePosition;

    public Line(String[] participants) {
        int participantNumber = participants.length;
        int rowLineNumber = participantNumber - 1;
        rowLinePosition = RowLinePositions.create(rowLineNumber);
    }

    public boolean isTruePosition(int index) {
        return rowLinePosition.isTrue(index);
    }
}
