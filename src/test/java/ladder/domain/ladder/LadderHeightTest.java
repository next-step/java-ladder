package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LadderHeightTest {

    @Test
    @DisplayName("사다리 높이 생성")
    void create() {
        LadderHeight height = new LadderHeight(5);
        assertThat(height).isEqualTo(new LadderHeight(5));
    }

    @Test
    @DisplayName("높이가 0 이하 값 검증 -> IllegalArgumentException")
    void valid() {
        assertThatThrownBy(() -> new LadderHeight(0))
                .isInstanceOf(IllegalArgumentException.class);
        // 정상
        assertThatCode(() -> new LadderHeight(1))
                .doesNotThrowAnyException();
    }

}