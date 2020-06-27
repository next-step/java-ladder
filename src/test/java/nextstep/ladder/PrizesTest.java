package nextstep.ladder;

import ladder.domain.Prizes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PrizesTest {

    @ParameterizedTest
    @DisplayName("보상 결과 유효성 테스트")
    @NullAndEmptySource
    void InvalidPrizesTest(String inputNull){
        assertThatThrownBy(() -> Prizes.of(inputNull))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Prizes.LADDER_RESULTS_NULL_EXCEPTION);
    }
}
