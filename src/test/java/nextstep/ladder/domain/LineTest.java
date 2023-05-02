package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("라인 생성 테스트")
    void createLineTest(boolean input) {
        assertThat(new Line(input))
                .isInstanceOf(Line.class);
    }

    @Test
    @DisplayName("라인 소유 테스트")
    void hasLineTest() {
        assertThat(new Line(true).hasLine())
                .isTrue();
    }

    @Test
    @DisplayName("라인 미소유 테스트")
    void hasNoLineTest() {
        assertThat(new Line(false).hasLine())
                .isFalse();
    }
}