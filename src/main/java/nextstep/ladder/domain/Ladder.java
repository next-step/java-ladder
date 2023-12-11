package nextstep.ladder.domain;

import nextstep.ladder.exception.CannotMakeLadderException;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private final ArrayList<Line> lines;

    public static Ladder generate(int countOfParticipant, int ladderHeight) {
        validateHeight(ladderHeight);
        return new Ladder((ArrayList<Line>) Stream.generate(() -> new Line(countOfParticipant))
                .limit(ladderHeight)
                .collect(Collectors.toList()));
    }

    private static void validateHeight(int ladderHeight) {
        if (ladderHeight < 1) {
            throw new CannotMakeLadderException("사다리 높이는 1보다 작을 수 없습니다.");
        }
    }

    private Ladder(ArrayList<Line> lines) {
        this.lines = lines;
    }

    public int getHeight() {
        return lines.size();
    }

    public ArrayList<Line> getLines() {
        return lines;
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "lines=" + lines +
                '}';
    }
}
