package nextstep.ladder.domain.result;

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
    void 참가자_수와_사다리_결과_수가_일치하지_않을때_예외발생() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                LadderResultGroup.of("pobi,honux,crong,jk", 3));
    }

    @Test
    void 입력받은_사다리_결과_문자열이_빈문자일때_예외_발생() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderResultGroup.of("", 0));
    }
}
