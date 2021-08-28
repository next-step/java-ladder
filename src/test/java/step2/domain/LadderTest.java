package step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
    @DisplayName("높이 1이하 예외처리 테스트")
    @Test
    void ladder_height_exception() {
        Assertions.assertThatThrownBy(() -> {
            new Ladder(0);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}