package ladder.domain.prize;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import ladder.exception.InvalidPrizeNameException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class LadderPrizeTest {

    @ParameterizedTest
    @NullAndEmptySource
    void of_Invalid(String prize) {
        assertThatThrownBy(() -> LadderPrize.of(prize))
                .isInstanceOf(InvalidPrizeNameException.class);
    }
}
