package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class PointTest {

    @DisplayName("라인의 각각의 좌표를 의미하는 Point 객체를 생성한다.")
    @EnumSource(value = Direction.class)
    @ParameterizedTest
    void create(Direction direction) {
        Point point = new Point(0, direction);
        assertThat(point).isEqualTo(new Point(0, direction));
    }

}
