package nextstep.step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderHeightTest {
    @Test
    @DisplayName("사다리 높이를 입력으로 LadderHeight 객체를 생성할 수 있다.")
    void testLadderHeightConstructor() {
        //given
        int height = 20;

        //when
        LadderHeight ladderHeight = new LadderHeight(height);

        //then
        assertThat(ladderHeight).isNotNull();
    }
}
