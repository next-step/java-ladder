package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.ladder.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTests {
    @DisplayName("boolean 값을 인자로 객체를 생성 할 수 있다.")
    @Test
    void createTest() {
        assertThat(new Point(true)).isNotNull();
        assertThat(new Point(true)).isEqualTo(new Point(true));
    }
}
