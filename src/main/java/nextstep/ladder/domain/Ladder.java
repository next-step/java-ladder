package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    public final static int MIN_HEIGHT = 1;
    private List<Line> lines = new ArrayList<>();

    public Ladder(int countOfPlayers, int ladderHeight) {
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
            lines().add(new Line(countOfPerson));
        }
    }

    public List<Line> lines() {
        return lines;
    }

    public int size() {
        return lines.size();
    }

    public String toString() {
        return lines.stream()
                .map(line -> "     " + line.toString())
                .collect(Collectors.joining("\n"));
    }
}
