package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionsTests {
    @DisplayName("생성 테스트")
    @Test
    void create() {
        Positions positions = Positions.of(Arrays.asList(2, 1, 3, 0));

        assertThat(positions).isEqualTo(Positions.of(Arrays.asList(2, 1, 3, 0)));
    }

    @DisplayName("최종 위치들 객체 에게 초기 결과들을 줬을 때 최종 결과를 매핑 해주는지 테스트")
    @Test
    void makeFinalResultsTest() {
        Positions positions = Positions.of(Arrays.asList(2, 1, 3, 0));

        assertThat(positions.makeFinalResults(Arrays.asList("꽝", "5000", "꽝", "3000")))
                .isEqualTo(Arrays.asList("꽝", "5000", "3000", "꽝"));
    }
}
