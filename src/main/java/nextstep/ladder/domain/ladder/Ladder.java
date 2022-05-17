package nextstep.ladder.domain.ladder;

import nextstep.ladder.util.ConnectStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private static final int MIN_HEIGHT = 1;
    private final List<LadderLine> ladderLines;

    private Ladder(List<LadderLine> ladderLines) {
        this.ladderLines = ladderLines;
    }

    public static Ladder from(int height, int sizeOfPerson, ConnectStrategy connectStrategy) {
        validateHeight(height);
        List<LadderLine> ladderLines = new ArrayList<>();
        for (int i = 1; i <= height; i++) {
            ladderLines.add(LadderLine.from(sizeOfPerson, connectStrategy));
        }
        return new Ladder(ladderLines);
    }

    private static void validateHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("[ERROR] 사다리의 높이는 1이상이어야 합니다.");
        }
    }

    @Override
    public String toString() {
        return ladderLines.stream()
                .map(LadderLine::toString)
                .collect(Collectors.joining("\n"));
    }
}
