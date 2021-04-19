package finalRefactor.domain;

import java.util.*;

public class Ladder {

    private final List<LadderLine> lines;

    public Ladder(Height height, int countOfPerson) {
        this.lines = createLines(height, countOfPerson);
    }

    public Ladder(List<LadderLine> lines) {
        this.lines = lines;
    }

    private List<LadderLine> createLines(Height height, int countOfPerson) {
        List<LadderLine> lines = new ArrayList<>();
        for (int i = 0; i < height.getValue(); i++) {
            lines.add(new LadderLine(countOfPerson));

        }
        return lines;
    }

    public int eachPositionResult(int position) {
        for (LadderLine line : lines) {
            position = line.move(position);
        }
        return position;
    }

    public ExecutionResult eachPositionExecutionResult(int position, ExecutionResults results) {
        for (LadderLine line : lines) {
            position = line.move(position);
        }

        return results.getOneResult(position);
    }

    public ExecutionResults getExecutionResult(ExecutionResults executionResults) {
        List<ExecutionResult> executionResultsList = new ArrayList<>();
        for (int i = 0; i < executionResults.size(); i++) {
            executionResultsList.add(eachPositionExecutionResult(i, executionResults));
        }
        return new ExecutionResults(executionResultsList);
    }

    public List<LadderLine> lines() {
        return Collections.unmodifiableList(lines);
    }

}
