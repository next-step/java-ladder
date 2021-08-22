package ladder.domain.prize;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import ladder.exception.InvalidPrizeNamesException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class LadderPrizesTest {

    LadderPrizes ladderPrizes;

    @BeforeEach
    void setUp() {
        ladderPrizes = LadderPrizes.of(Arrays.asList("꽝", "5000", "꽝", "3000"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void invalid_of(List<String> prizes) {
        assertThatThrownBy(() -> LadderPrizes.of(prizes))
                .isInstanceOf(InvalidPrizeNamesException.class);
    }

    @Test
    void getPrizeByIndex() {
        LadderPrize prize = ladderPrizes.getPrizeByIndex(1);
        assertThat(prize).isEqualTo(LadderPrize.of("5000"));
    }

    @Test
    void size() {
        assertThat(ladderPrizes.size()).isEqualTo(4);
    }

    @Test
    void maxLength() {
        assertThat(ladderPrizes.maxLength()).isEqualTo(4);
    }
}
