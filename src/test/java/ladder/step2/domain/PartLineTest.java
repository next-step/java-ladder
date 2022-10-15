package ladder.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PartLineTest {
    @Test
    @DisplayName("해당 부분 라인 존재 여부 확인")
    void is_exist() {
        assertAll(
                () -> assertThat(new PartLine(true).isExist()).isTrue(),
                () -> assertThat(new PartLine(false).isExist()).isFalse()
        );
    }
}