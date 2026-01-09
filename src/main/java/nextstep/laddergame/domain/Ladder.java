package nextstep.laddergame.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public record Ladder(List<Line> lines, List<Goal> goals) {

    public Ladder(String ladderHeight, int countOfPerson) {
        this(Integer.parseInt(ladderHeight), countOfPerson);
    }

    public Ladder(int ladderHeight, int countOfPerson) {
        this(getLines(ladderHeight, countOfPerson), Stream.generate(() -> "").limit(countOfPerson).toArray(String[]::new));
    }

    public Ladder(int ladderHeight, int countOfPerson, String... goals) {
        this(getLines(ladderHeight, countOfPerson), getGoals(goals));
    }

    private static List<Goal> getGoals(String[] goals) {
        return Arrays.stream(goals).map(Goal::new).toList();
    }

    private static List<Line> getLines(int ladderHeight, int countOfPerson) {
        return IntStream.range(0, ladderHeight).mapToObj(i -> new Line(countOfPerson)).toList();
    }

    public Ladder(List<Line> lines, String... goals) {
        this(lines, getGoals(goals));
    }

    public Ladder {
        validate(lines, goals);
    }

    private void validate(List<Line> lines, List<Goal> goals) {
        if (lines.getFirst().size() != goals.size()) {
            throw new IllegalArgumentException("사다리와 결과값이 다르다");
        }
    }

    public String traverse(int startPosition) {
        int currentPosition = startPosition;

        for (Line line : lines) {
            currentPosition = line.nextPosition(currentPosition);
        }

        return goals.get(currentPosition).goal();
    }

}
