package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Ladder {
    public final static int MIN_HEIGHT = 1;
    private final ConditionStrategy randomCondition = new RandomCondition();
    private List<Line> lines = new ArrayList<>();

    private Ladder(int countOfPlayers, int ladderHeight) {
        validation(ladderHeight);
        create(countOfPlayers, ladderHeight);
    }

    private void validation(int ladderHeight) {
        if (ladderHeight < MIN_HEIGHT) {
            throw new IllegalArgumentException("사다리의 최소 높이는 1보다 커야 합니다.");
        }
    }

    private void create(int countOfPerson, int ladderHeight) {
        for (int i = 0; i < ladderHeight; i++) {
            lines.add(new Line(countOfPerson, randomCondition));
        }
    }

    public int size() {
        return lines.size();
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static Ladder of(int countOfPlayers, int ladderHeight) {
        return new Ladder(countOfPlayers, ladderHeight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(randomCondition, ladder.randomCondition) && Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(randomCondition, lines);
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "randomCondition=" + randomCondition +
                ", lines=" + lines +
                '}';
    }
}
