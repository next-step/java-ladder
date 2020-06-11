package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("Point 클래스 테스트")
class PointTest {

    @DisplayName("Point 객체를 생성할 수 있다.")
    @Test
    void create() {
        assertThatCode(() -> new Point(new RandomPointGenerationStrategy()))
                .doesNotThrowAnyException();
    }
}
