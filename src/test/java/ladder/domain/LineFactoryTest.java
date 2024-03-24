package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class LineFactoryTest {

    @RepeatedTest(100)
    @DisplayName("사다리 한 줄이 정상적으로 생성된다")
    void generate() {
        assertThatNoException()
            .isThrownBy(() -> LineFactory.generate(5));
    }
}
