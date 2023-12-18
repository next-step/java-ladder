package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ResultInfoTest {
    @Test
    @DisplayName("실행 결과를 입력할 수 있다.")
    void saveResultInfoTest() {
        ResultInfo resultInfo = new ResultInfo("a,b", 2);

        assertThat(resultInfo.getResults().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("참가자보다 적게 입력하는 경우 Exception 발생")
    void wrongResultInfoExceptionTest() {
        Participants participants = new Participants("a,b");

        assertThrows(IllegalArgumentException.class, () -> new ResultInfo("a", participants.count()));
    }
}
