package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParticipantNamesTest {

    @Test
    @DisplayName("[요구사항 1] 참가자의 이름 숫자가 1명 미만일 경우 throw IllegalArgumentException")
    void 요구사항_1() {
        // given
        String[] executionResultsInput = {};

        // then
        Assertions.assertThatThrownBy(() -> new ParticipantNames(executionResultsInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참가자는 최소 1명 이상이어야 합니다.");
    }
}
