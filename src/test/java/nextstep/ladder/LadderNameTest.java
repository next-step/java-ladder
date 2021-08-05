package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderNameTest {
    @Test
    @DisplayName("인원 생성 테스트")
    void create() {
        LadderName ladderName = LadderName.make("pobi,honux,crong,jk");
        assertThat(ladderName).isEqualTo(LadderName.make("pobi,honux,crong,jk"));
    }

    @Test
    @DisplayName("이름 5글자 예외처리")
    void ladderExceptionTest() {
        assertThatThrownBy(() -> LadderName.make("pobiaaaaa,honux,crong,jk"))
                .hasMessageContaining("5글자")
                .isInstanceOf(StringLengthException.class);
    }

    @Test
    @DisplayName("이름 공백 예외처리")
    void inputStrValidationTest() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> LadderName.make(""));
        assertThat(exception.getMessage()).isEqualTo("이름을 공백으로 할 수 없습니다.");
    }

}