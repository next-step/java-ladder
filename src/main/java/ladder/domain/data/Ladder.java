package ladder.domain.data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ladder.domain.LineGenerator;
import ladder.domain.RandomBooleanGenerator;

public class Ladder {

    public static final String INDENT = " ";
    private final List<Line> lines;
    private Goals goals;

    public Ladder() {
        this.lines = new ArrayList<>();
    }

    public Ladder(Goals goals) {
        this(List.of(), goals);
    }

    public Ladder(List<Line> lines, Goals goals) {
        this.lines = new ArrayList<>(lines);
        this.goals = goals;
    }

    public static Ladder of(Goals goals, LadderHeight ladderHeight) {
        LineGenerator generator = new LineGenerator(new RandomBooleanGenerator());
        List<Line> lines = Stream.generate(() -> generator.generate(goals.size()))
            .limit(ladderHeight.value())
            .collect(Collectors.toList());
        return new Ladder(lines, goals);
    }

    public List<Result> runAll(Persons persons) {
        return persons.persons().stream()
            .map(this::run)
            .collect(Collectors.toList());
    }

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
