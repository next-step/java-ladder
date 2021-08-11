package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderJackpotsTest {
    @Test
    @DisplayName("당첨결과 생성 테스트")
    void create() {
        String initPerson = "a,b,c,d";
        String excutionResults = "1,2,3,4";

        LadderJackpots.of(excutionResults, initPerson);
    }


    @Test
    @DisplayName("당첨 결과 예외 테스트")
    void exceptionTest() {
        String initPerson = "a,b,c,d";
        String excutionResults = "1,2,3,4,5";

        assertThatThrownBy(() -> {
            LadderJackpots.of(excutionResults, initPerson);
        }).hasMessageContaining("사람과 당첨 결과의 수는 같아야 합니다.")
            .isInstanceOf(IllegalArgumentException.class);
    }

}