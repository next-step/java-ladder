package ladder.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PartLineTest {
    public static final PartLine TRUE = new PartLine(true);
    public static final PartLine FALSE = new PartLine(false);
    
    @Test
    @DisplayName("해당 부분 라인 존재 여부 확인")
    void is_exist() {
        assertAll(
                () -> assertThat(TRUE.isExist()).isTrue(),
                () -> assertThat(FALSE.isExist()).isFalse()
        );
    }
}