package nextstep.step2.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @DisplayName("isGo() 포인트의 값에 따라 true / false 를 반환한다.")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void isGoTest(boolean input) {
        Point actual = Point.create(input);

        assertThat(actual.isGo()).isEqualTo(input);
    }

    @DisplayName("getCachedPoint()는 이미 생성된 포인트를 반환한다.")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void getCachedPointTest(boolean input) {
        Point actual = Point.getCachedPoint(input);

        assertThat(actual).isEqualTo(Point.create(input));
        assertThat(actual).isNotSameAs(Point.create(input));

        assertThat(actual).isEqualTo(Point.getCachedPoint(input));
        assertThat(actual).isSameAs(Point.getCachedPoint(input));
    }

}
