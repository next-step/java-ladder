package ladder.domain;

import ladder.domain.strategy.CoordinateGeneration;
import ladder.domain.strategy.ManualCoordinateGeneration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CoordinateTest {
    private static final CoordinateGeneration COORDINATE_GENERATION = new ManualCoordinateGeneration();

    @Test
    @DisplayName("사다리의 현재 좌표가 이어져 있을 경우 다음 좌표 이어지지 않는지 확인 ")
    void 사다리_다음좌표_생성() {
        Coordinate coordinate = Coordinate.valueOf(COORDINATE_GENERATION.generate());

        assertThat(coordinate.next(COORDINATE_GENERATION.generate()).find()).isFalse();

    }
}
