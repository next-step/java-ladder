package ladder.domain.result;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LadderResultTest {

    @Test
    void createLadderResult() {
        String input = "test";

        LadderResult ladderResult = LadderResult.of(input);

        assertThat(ladderResult.getResult()).isEqualTo(input);
    }
}
