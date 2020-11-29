package nextstep.ladder.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class PointTest {
    @Test
    @DisplayName("first point의 right가 true이면 다음 인덱스는 1, false 이면 다음 인덱스가 0이다.")
    void firstPointTest() {
        assertAll(
                () ->  assertThat(Point.first(true).move()).isEqualTo(1),
                () ->  assertThat(Point.first(false).move()).isEqualTo(0)
        );
    }
}
