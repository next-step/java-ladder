package nextstep.laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderResultsTest {

    @DisplayName("참여자의 사다리 결과를 반환한다.")
    @Test
    public void ladderResultsTest() {
        LadderResults ladderResults = new LadderResults(Collections.singletonMap(PlayerName.of("yunb"), "5000"));
        assertThat(ladderResults.getResult("yunb")).isEqualTo("5000");
    }

    @DisplayName("존재하지 않는 참여자의 이름이 입력되면 예외가 발생한다.")
    @Test
    public void noSuchPlayerExceptionTest() {
        LadderResults ladderResults = new LadderResults(Collections.singletonMap(PlayerName.of("yunb"), "5000"));
        assertThatThrownBy(() -> ladderResults.getResult("noone"))
                .isExactlyInstanceOf(NoSuchElementException.class)
                .hasMessageContaining("noone");
    }

}