package nextstep.ladder2.domain;

import java.util.Collections;
import java.util.List;
import nextstep.ladder2.domain.builder.LadderBuilder;

public class NxLadder {
    private static final int LADDER_MIN_HEIGHT = 1;
    private static final int LADDER_MIN_PEOPLE = 2;

    private final List<NxLine> lines;

    public NxLadder(int height, int countOfPerson, LadderBuilder ladderBuilder) {
        if (height < LADDER_MIN_HEIGHT) {
            throw new IllegalArgumentException("사다리 높이는 1 이상이어야 합니다: " + height);
        }
        if (countOfPerson < LADDER_MIN_PEOPLE) {
            throw new IllegalArgumentException("참여자 수는 2 이상이어야 합니다: " + countOfPerson);
        }
        lines = ladderBuilder.build(height, countOfPerson);
    }

    public int ride(int startIndex) {
        int updatedIndex = startIndex;
        for (NxLine line : lines) {
            updatedIndex = line.movePosition(updatedIndex);
        }
        return updatedIndex;
    }

    public List<NxLine> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
