package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("Point 클래스 테스트")
class PointTest {

    @DisplayName("Boolean 값을 입력 받아 Point 객체를 생성할 수 있다.")
    @Test
    void of() {
        assertThatCode(() -> Point.of(false))
                .doesNotThrowAnyException();
    }

    @DisplayName("PointGenerationStrategy 타입을 입력 받아 Point 객체를 생성할 수 있다.")
    @Test
    void ofStrategy() {
        assertThatCode(() -> Point.ofStrategy(new RandomPointGenerationStrategy()))
                .doesNotThrowAnyException();
    }
}
