package nextstep.laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PlayResultsTest {

    @DisplayName("참여자 수와 실행결과 수가 일치하지 않는 경우 예외가 발생한다.")
    @Test
    public void invalidPlayResultsTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PlayResults.with(3, Arrays.asList("꽝","5000","꽝","3000")))
                .withMessageContainingAll("3", "4");
    }

}