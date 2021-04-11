package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PointTest {

    @Test
    void create() {
        assertThatCode(() -> Point.from(new RandomBooleanStrategy())).doesNotThrowAnyException();
    }

    @DisplayName("true Point가 생성되면 다음 Point는 ture 일 수 없다.")
    @Test
    void nextPoint() {
        Point truePoint = Point.from(true);
        assertThat(truePoint.nextPoint()).usingRecursiveComparison().isEqualTo(Point.from(false));
    }
}
