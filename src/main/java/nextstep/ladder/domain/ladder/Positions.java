package nextstep.ladder.domain.ladder;

import java.util.List;

public class Positions {

    private static final int MINIMUM_POSITION_SIZE = 2;

    private final List<Position> positions;

    public Positions(final List<Position> positions) {
        validate(positions.size());
        this.positions = positions;
    }

    private void validate(int maxPosition) {
        if (maxPosition < MINIMUM_POSITION_SIZE) {
            throw new IllegalArgumentException("사다리 위치 리스트의 최소 크기는 " + MINIMUM_POSITION_SIZE + "입니다.");
        }
    }
}
