package ladder.domain;

public class Line {
    private RowLinePositions rowLinePositions;

    public Line(String[] participants) {
        int participantNumber = participants.length;
        int rowLineNumber = participantNumber - 1;
        rowLinePositions = new RowLinePositions(rowLineNumber);
    }

    public boolean isPosition(int index) {
        return rowLinePositions.isPosition(index);
    }
}
