package step3.domain;

import step3.Result;

import java.util.*;

public class Lines {

    private final List<Line> lines;

    public Lines(Height height, int countOfPerson) {
        this.lines = createLines(height, countOfPerson);
    }

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    private List<Line> createLines(Height height, int countOfPerson) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height.height(); i++) {
            lines.add(new Line(countOfPerson));

        }
        return lines;
    }

    public int eachPositionResult(int position) {
        for (Line line : lines) {
            position = line.move(position);
        }

        return position;
    }

    public Result result(Persons persons, ExecutionResults executionResults) {
        Map<Person, ExecutionResult> resultMap = new HashMap<>();

        for (int i = 0; i < persons.personList().size(); i++) {
            resultMap.put(persons.personList().get(i), executionResults.oneResult(eachPositionResult(i)));
        }
        return new Result(resultMap);
    }

    public ExecutionResult eachPositionResult2(int position, ExecutionResults results) {
        for (Line line : lines) {
            position = line.move(position);
        }

        return results.oneResult(position);
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

}
