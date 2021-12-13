package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class HeightTest {

    @DisplayName("높이 생성 테스트")
    @Test
    void create() {
        int actual = 2;

        Height expected = new Height(actual);

        assertThat(expected).isNotNull();
        assertThat(expected.getValue()).isEqualTo(actual);
    }

    @DisplayName("높이는 1보다 작으면 예외를 발생")
    @Test
    void createHeightMoreThanOne() {
        assertThatThrownBy(() -> new Height(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
