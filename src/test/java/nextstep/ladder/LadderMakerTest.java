package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderMakerTest {
    @Test
    @DisplayName("사다리 게임 사람 추가하기")
    void ladderCreateTest() {
        LadderMaker.of("pobi,honux,crong,jk");
    }

    @Test
    @DisplayName("사다리 게임 5글자 예외처리")
    void ladderExceptionTest() {
        assertThatThrownBy(() -> LadderMaker.of("pobiaaaaa,honux,crong,jk"))
                                            .hasMessageContaining("5글자")
                                            .isInstanceOf(IllegalArgumentException.class);

    }
}
