package nextstep.ladder;

import nextstep.ladder.line.HorizontalLine;
import nextstep.ladder.result.ExecutionResult;

import java.util.List;

public class Ladder {

    private final int numberOfParticipants;
    private List<HorizontalLine> horizontalLines;

    public Ladder(int numberOfParticipants, List<HorizontalLine> horizontalLines) {
        this.numberOfParticipants = numberOfParticipants;
        this.horizontalLines = horizontalLines;
    }

    public ExecutionResult startGame() {
        ExecutionResult executionResult = new ExecutionResult();

        for (int i = 0; i < numberOfParticipants; i++) {
            int resultIndex = getResultIndex(i);
            executionResult.put(i, resultIndex);
        }

        return executionResult;
    }

    private int getResultIndex(int position) {
        int index = position;
        for (HorizontalLine horizontalLine : horizontalLines) {
            index = horizontalLine.move(index);
        }
        return index;
    }

    public List<HorizontalLine> getHorizontalLines() {
        return horizontalLines;
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "numberOfParticipants=" + numberOfParticipants +
                ", horizontalLines=" + horizontalLines +
                '}';
    }
}
