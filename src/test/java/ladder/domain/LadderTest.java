package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static ladder.domain.Ladder.LADDER_HEIGHT_MUST_MORE_THEN_ONE;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LadderTest {
    @Test
    void of() {
        // given
        final int userCount = 4;
        final int ladderHeight = 5;

        // when
        final Ladder ladder = Ladder.of(userCount, ladderHeight);

        // then
        assertThat(ladder).isNotNull();
        assertThat(ladder.size()).isEqualTo(5);
    }

    @Test
    void of_throw_exception_when_height_not_more_then_one() {
        // given
        final int userCount = 5;
        final int ladderHeight = 0;

        // when 
        final Throwable thrown = catchThrowable(() -> {
            LadderGame.of(userCount, ladderHeight);
        });

        // then
        Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LADDER_HEIGHT_MUST_MORE_THEN_ONE);
    }
}
