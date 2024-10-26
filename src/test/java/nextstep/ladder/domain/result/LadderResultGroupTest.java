package nextstep.ladder.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderResultGroupTest {

    @Test
    void create() {
        LadderResultGroup ladderResultGroup = LadderResultGroup.of("3000,꽝,2000,1000", 4);

        assertThat(ladderResultGroup).isEqualTo(new LadderResultGroup(List.of("3000", "꽝", "2000", "1000")));
    }

    @Test
    @DisplayName("입력 받은 참가자 수와 입력 받은 사다리 결과 수가 일치하지 않을 때 예외가 발생한다")
    void throwExceptionIfCountNotMatch() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                LadderResultGroup.of("pobi,honux,crong,jk", 3));
    }

    @Test
    @DisplayName("입력받은 사다리 결과가 문자열이 빈문자일때 예외가 발생한다")
    void throwExceptionIfEmptyString() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderResultGroup.of("", 0));
    }
}
