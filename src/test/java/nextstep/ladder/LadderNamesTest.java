package nextstep.ladder;

import nextstep.ladder.domain.LadderNames;
import nextstep.ladder.exception.StringLengthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderNamesTest {
    @Test
    @DisplayName("인원 생성 테스트")
    void create() {
        LadderNames ladderNames = LadderNames.make("pobi,honux,crong,jk");
        assertThat(ladderNames).isEqualTo(LadderNames.make("pobi,honux,crong,jk"));
    }

    @Test
    @DisplayName("이름 5글자 예외처리")
    void ladderExceptionTest() {
        assertThatThrownBy(() -> LadderNames.make("pobiaaaaa,honux,crong,jk"))
                .hasMessageContaining("5글자")
                .isInstanceOf(StringLengthException.class);
    }

    @Test
    @DisplayName("이름 공백 예외처리")
    void inputStrValidationTest() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> LadderNames.make(""));
        assertThat(exception.getMessage()).isEqualTo("이름을 공백으로 할 수 없습니다.");
    }

}