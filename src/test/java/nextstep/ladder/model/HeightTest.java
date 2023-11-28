package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HeightTest {
    @Test
    @DisplayName("사다리 높이는 최소 1이상")
    void test1() {
        //given
        int height = 0;
        //then
        assertThatThrownBy(() -> new Height(height))
                .hasMessageContaining("사다리의 최소 높이는 1입니다.");
    }
}