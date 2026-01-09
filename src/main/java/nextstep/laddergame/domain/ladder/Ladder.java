package nextstep.laddergame.domain.ladder;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public record Ladder(Lines lines, Goals goals) {

    public Ladder(String ladderHeight, int countOfPerson) {
        this(Integer.parseInt(ladderHeight), countOfPerson);
    }

    public Ladder(String ladderHeight, int countOfPerson, String goals) {
        this(Integer.parseInt(ladderHeight), countOfPerson, goals.split(","));
    }

    public Ladder(int ladderHeight, int countOfPerson) {
        this(getLines(ladderHeight, countOfPerson), Stream.generate(() -> "").limit(countOfPerson).toArray(String[]::new));
    }

    public Ladder(int ladderHeight, int countOfPerson, String... goals) {
        this(getLines(ladderHeight, countOfPerson), getGoals(goals));
    }

    private static Goals getGoals(String[] goals) {
        return new Goals(Arrays.stream(goals).map(Goal::new).toList());
    }

    private static Lines getLines(int ladderHeight, int countOfPerson) {
        return new Lines(IntStream.range(0, ladderHeight).mapToObj(i -> new Line(countOfPerson)).toList());
    }

    public Ladder(Lines lines, String... goals) {
        this(lines, getGoals(goals));
    }

    public Ladder {
        validate(lines, goals);
    }

    private void validate(Lines lines, Goals goals) {
        if (lines.lineList().getFirst().size() != goals.goalList().size()) {
            throw new IllegalArgumentException("사다리와 결과값이 다르다");
        }
    }

    public String traverse(int startPosition) {
        int currentPosition = startPosition;

        for (Line line : lines.lineList()) {
            currentPosition = line.nextPosition(currentPosition);
        }

        return goals.goalList().get(currentPosition).value();
    }

}
