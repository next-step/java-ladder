package ladder.domain.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InputLadderResultTest {

    @Test
    void 당첨될_결과를_생성한다() {
        // given
        String input = "꽝,5000,꽝,3000";

        // then
        InputLadderResult inputLadderResult = new InputLadderResult(input);

        // then
        assertThat(inputLadderResult.size()).isEqualTo(4);
    }

    @Test
    void 결과를_검색한다() {
        // given
        String input = "꽝,5000,꽝,3000";
        InputLadderResult inputLadderResult = new InputLadderResult(input);

        // then
        assertThat(inputLadderResult.findResult(1)).isEqualTo("5000");
    }
}