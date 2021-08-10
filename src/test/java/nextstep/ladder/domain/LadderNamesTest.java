package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderNamesTest {
    @Test
    @DisplayName("인원 생성 테스트")
    void create() {
        LadderNames ladderNames = LadderNames.of("pobi,honux,crong,jk");
        assertThat(ladderNames).isEqualTo(LadderNames.of("pobi,honux,crong,jk"));
    }

    @Test
    @DisplayName("이름 공백 예외처리")
    void inputStrValidationTest() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> LadderNames.of(""));
        assertThat(exception.getMessage()).isEqualTo("이름을 공백으로 할 수 없습니다.");
    }

}