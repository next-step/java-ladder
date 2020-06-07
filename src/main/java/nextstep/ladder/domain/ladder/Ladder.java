package nextstep.ladder.domain.ladder;

import java.util.List;

public class Ladder {

    private static final int MINIMUM_POSITION_SIZE = 2;
    private final List<Position> positions;

    public Ladder(List<Position> positions) {
        validate(positions);
        this.positions = positions;
    }

    private void validate(List<Position> positions) {
        if(positions.size() < MINIMUM_POSITION_SIZE) {
            throw new IllegalArgumentException("사다리 위치 리스트의 최소 크기는 " + MINIMUM_POSITION_SIZE + "입니다.");
        }
    }
}
