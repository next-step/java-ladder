package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputResultTest {

    @Test
    @DisplayName("InputResult 생성")
    void createInputResult() {
        String results = "1,2,3";
        int usersNumber = 3;

        InputResult inputResult = InputResult.createInputResult(results, usersNumber);
        String[] splitResults = inputResult.splitResults();

        assertThat(splitResults.length).isEqualTo(3);
    }

    @Test
    @DisplayName("참가자수와 결과수가 맞지 않을 경우 예외 처리")
    void inputResultException() {
        String results = "1,2,3";
        int usersNumber = 4;

        assertThrows(IllegalArgumentException.class,
                () -> InputResult.createInputResult(results, usersNumber));
    }

}
