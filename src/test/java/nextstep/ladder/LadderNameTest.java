package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderNameTest {
    @Test
    @DisplayName("인원 생성 테스트")
    void create() {
        LadderName ladderName = new LadderName("pobi,honux,crong,jk");
        assertThat(ladderName).isEqualTo(new LadderName("pobi,honux,crong,jk"));
    }

    @Test
    @DisplayName("이름 5글자 예외처리")
    void ladderExceptionTest() {
        assertThatThrownBy(() -> new LadderName("pobiaaaaa,honux,crong,jk"))
                .hasMessageContaining("5글자")
                .isInstanceOf(StringLengthException.class);
    }

}