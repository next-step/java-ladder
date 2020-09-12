package step04.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderHeightTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        // given & when
        LadderHeight ladderHeight = new LadderHeight(5);
    }

    @DisplayName("최소 높이를 만족하지 못할때 생성 실패 테스트")
    @Test
    void create_최소높이_불만족_실패() {
        // when & then
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LadderHeight(0);
        });
    }
}
