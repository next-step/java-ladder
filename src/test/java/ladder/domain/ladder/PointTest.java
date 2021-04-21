package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @DisplayName("Point 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        boolean inputBoolean = true;

        // when
        Point point = Point.of(inputBoolean);

        // then
        assertThat(point).isNotNull();
    }

    @DisplayName("Point가 첫번째로 와야할 Point를 반환하는지 테스트")
    @Test
    void 반환_첫번째값() {
        // when
        Point point = Point.first();

        // then
        assertThat(point).isNotNull();
    }

    @DisplayName("Point 인스턴스가 소유한 값이 true 인지 여부 테스트")
    @Test
    void 반환_소유값_참인지_여부() {
        // when
        boolean trueValue = true;
        boolean falseValue = false;

        Point truePoint = Point.of(trueValue);
        Point falsePoint = Point.of(falseValue);

        // then
        assertAll(
                () -> assertThat(truePoint.hasPoint()).isTrue(),
                () -> assertThat(falsePoint.hasPoint()).isFalse()
        );
    }

}