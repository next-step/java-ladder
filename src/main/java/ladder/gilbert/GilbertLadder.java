package ladder.gilbert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ladder.engine.Ladder;
import ladder.engine.Line;
import ladder.gilbert.domain.data.*;

public class GilbertLadder implements Ladder {

    private final List<Line> lines;
    private Goals goals;

    public GilbertLadder() {
        this.lines = new ArrayList<>();
    }

    public GilbertLadder(List<Line> lines, Goals goals) {
        this.lines = new ArrayList<>(lines);
        this.goals = goals;
    }

    @Override
    public List<Result> runAll(Persons persons) {
        return persons.persons().stream()
            .map(this::run)
            .collect(Collectors.toList());
    }

    @Override
    public Result run(Person person) {
        int currentIndex = person.order();
        for (Line line: lines) {
            currentIndex = line.run(currentIndex);
        }
        return new Result(person, goals.get(currentIndex));
    }

    public void add(Line line) {
        lines.add(line);
    }

    public List<Line> lines() {
        return lines;
    }

    public Goals goals() {
        return goals;
    }
}
