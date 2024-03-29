package ladder2.domain.factory;

import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class LadderRowFactoryTest {

    @RepeatedTest(100)
    @DisplayName("사다리 한 행이 정상적으로 생성된다")
    void generate() {
        assertThatNoException()
            .isThrownBy(() -> LadderRowFactory.generate(5));
    }
}
