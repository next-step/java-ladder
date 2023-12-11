package ladder.gilbert;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import ladder.engine.*;
import ladder.gilbert.domain.data.Goals;

public class GilbertLadder implements Ladder {

    private final List<Line> lines;
    private Goals goals;

    public GilbertLadder(List<Line> lines) {
        this.lines = new ArrayList<>(lines);
    }

    public GilbertLadder(List<Line> lines, Goals goals) {
        this.lines = lines;
        this.goals = goals;
    }

    public GilbertLadder with(Goals goals) {
        return new GilbertLadder(lines, goals);
    }

    @Override
    public Result runAll(int numberOfPersons) {
        Map<Integer, Integer> map = IntStream.range(0, numberOfPersons)
            .boxed()
            .collect(Collectors.toMap(Function.identity(), this::indexAfterLineRunning));
        return new Result(map);
    }

    @Override
    public Result run(int personOrder) {
        Result result = new Result();
        int currentIndex = indexAfterLineRunning(personOrder);
        result.put(personOrder, currentIndex);
        return result;
    }

    private int indexAfterLineRunning(int personOrder) {
        int currentIndex = personOrder;
        for (Line line: lines) {
            currentIndex = line.run(currentIndex);
        }
        return currentIndex;
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
