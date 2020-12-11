package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ResultTest {

    @Test
    @DisplayName("결과 생성")
    void result() {
        String answer = "꽝";
        Result result = Result.from(answer);

        assertThat(result.getResult()).isEqualTo("꽝");
    }

    @Test
    @DisplayName("빈값일 경우 예외처리")
    void emptyException() {
        String answer = "";

        assertThrows(IllegalArgumentException.class,
                () -> Result.from(answer));
    }

}