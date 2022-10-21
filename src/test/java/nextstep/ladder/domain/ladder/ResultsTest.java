 package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.player.Results;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultsTest {

    @DisplayName("1개 미만의 Result로 생성하는 경우 예외가 발생한다.")
    @Test
    void resultsException() {
        assertThatThrownBy(() -> new Results(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
