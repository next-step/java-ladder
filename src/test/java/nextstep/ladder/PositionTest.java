package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    private static final int DEFAULT_POSITION = 0;

    @Test
    @DisplayName("한줄 사다리에서 정상 결과 출력 테스트")
    public void findLastPosition_test() {
        Position position = new Position(DEFAULT_POSITION);
        Ladder ladder = new Ladder(5, 1);
        assertThat(position.findLastPosition(ladder)).isEqualTo(DEFAULT_POSITION);
    }
}
