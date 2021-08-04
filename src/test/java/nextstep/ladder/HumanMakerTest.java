package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HumanMakerTest {
    @Test
    @DisplayName("사다리 게임 사람 추가하기")
    void ladderCreateTest() {
        HumanMaker.of("pobi,honux,crong,jk");
    }

    @Test
    @DisplayName("이름 5글자 예외처리")
    void ladderExceptionTest() {
        assertThatThrownBy(() -> HumanMaker.of("pobiaaaaa,honux,crong,jk"))
                                            .hasMessageContaining("5글자")
                                            .isInstanceOf(IllegalArgumentException.class);

    }
}
