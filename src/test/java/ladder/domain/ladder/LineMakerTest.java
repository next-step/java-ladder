package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineMakerTest {

    @Test
    @DisplayName("랜덤한 라인을 잘 만 들어 주었는지 확인")
    void createCountTest() {
        assertThat(LineMaker.makeLine(10).getBars())
                .hasSize(10);
    }

    @ParameterizedTest
    @DisplayName("양수만 가능")
    @ValueSource(ints = {0, -1})
    void countOver1Test(int size) {
        assertThatThrownBy(() -> LineMaker.makeLine(size))
                .isInstanceOf(RuntimeException.class);
    }

}