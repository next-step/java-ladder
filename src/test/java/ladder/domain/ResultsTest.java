package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class ResultsTest {

    @Test
    @DisplayName("참가자 수와 결과의 수는 동일해야 한다.")
    void equalSizeTest() {
        //given
        Results results = new Results(List.of("a", "b", "c"));
        int expected = 2;

        //when & then
        Assertions.assertThatIllegalStateException()
                .isThrownBy(() -> results.validateSize(expected))
                .withMessageContaining("참가자 수와 결과 수가 일치해야 합니다.");
    }
}