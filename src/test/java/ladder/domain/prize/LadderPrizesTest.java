package ladder.domain.prize;

import ladder.model.prize.LadderPrize;
import ladder.model.prize.LadderPrizes;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderPrizesTest {
    @Test
    void createTest() {
        //when
        LadderPrizes ladderPrizes = LadderPrizes.create(createFourLadderPrizes());

        //then
        assertThat(ladderPrizes.getLadderPrizes()).hasSize(4);
    }

    private List<LadderPrize> createFourLadderPrizes() {
        return Arrays.asList(
                new LadderPrize("꽝"),
                new LadderPrize("5000"),
                new LadderPrize("꽝"),
                new LadderPrize("3000"));
    }
}