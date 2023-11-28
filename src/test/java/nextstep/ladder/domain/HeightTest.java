package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class HeightTest {
    @Test
    void create() {
        final Height height = new Height(3);
        assertThat(height).isEqualTo(new Height(3));
    }

    @DisplayName("높이는 음수 일 수 없다.")
    @Test
    void 높이가_음수_일떄() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Height(-1);
        });
    }
}