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

    @DisplayName("가로라인은 겹치지 않아야 한다.")
    @Test
    void nextPoint() {
        Point truePoint = Point.from(true);
        assertThat(truePoint.nextPoint()).usingRecursiveComparison().isEqualTo(Point.from(false));
    }
}
