package ladder;

import ladder.model.LadderPrize;
import ladder.model.LadderPrizes;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderPrizesTest {
    @Test
    void createTest() {
        //given
        List<LadderPrize> allLadderPrizes = Arrays.asList(
                new LadderPrize("꽝"),
                new LadderPrize("5000"),
                new LadderPrize("꽝"),
                new LadderPrize("3000"));

        //when
        LadderPrizes ladderPrizes = LadderPrizes.create(allLadderPrizes);

        //then
        assertThat(ladderPrizes.getLadderPrizes()).hasSize(4);
    }
}