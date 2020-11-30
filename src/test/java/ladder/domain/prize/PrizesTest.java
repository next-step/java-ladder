package ladder.domain.prize;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static ladder.domain.prize.Prizes.NUMBER_OF_PRIZE_MUST_BE_MORE_THEN_TWO;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class PrizesTest {
    @Test
    void of() {
        // given
        final List<Prize> prizeList = Arrays.asList(Prize.of("1000"), Prize.of("꽝"));

        // when
        final Prizes prizes = Prizes.of(prizeList);

        // then
        assertThat(prizes.size()).isEqualTo(2);
    }

    @Test
    void of_throw_exception_when_number_of_prize_less_then_two() {
        // given
        final List<Prize> prizeList = Collections.singletonList(Prize.of("1000"));

        // when 
        final Throwable thrown = catchThrowable(() -> {
            Prizes.of(prizeList);
        });

        // then
        Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_OF_PRIZE_MUST_BE_MORE_THEN_TWO);
    }

    @Test
    void of_throw_exception_when_prize_list_null() {
        // when 
        final Throwable thrown = catchThrowable(() -> {
            Prizes.of(null);
        });

        // then
        Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_OF_PRIZE_MUST_BE_MORE_THEN_TWO);
    }
}
