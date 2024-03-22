package ladder;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LineFactoryTest {

    @RepeatedTest(100)
    @DisplayName("사다리 한 줄이 정상적으로 생성된다")
    void generate() {
        assertThatNoException()
            .isThrownBy(() -> LineFactory.generate(5));
    }
}
