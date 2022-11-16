package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class HeightTest {
    @Test
    @DisplayName("높이가 1미만일 경우 에러 발생")
    void 높이_테스트_실패() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Height(0));
        assertThatIllegalArgumentException().isThrownBy(() -> new Height(-1));
    }

    @Test
    @DisplayName("높이가 1이상일 경우")
    void 높이_테스트_성공() {
        assertThat(new Height(1).height()).isEqualTo(1);
        assertThat(new Height(2).height()).isEqualTo(2);
    }
}