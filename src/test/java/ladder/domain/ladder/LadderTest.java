package ladder.domain.ladder;

import ladder.domain.LadderGame;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.domain.ladder.Ladder.LADDER_HEIGHT_MUST_MORE_THEN_ONE;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LadderTest {
    private Ladder ladder;

    @BeforeEach
    void setUp() {
        final int userCount = 4;
        final int ladderHeight = 5;
        ladder = Ladder.of(userCount, ladderHeight);
    }

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

    @DisplayName("특정 지점에서 시작할 경우 마지막 지점을 반환")
    @Test
    void startAt() {
        // given
        final int startPosition = 1;

        // when
        final int lastPosition = ladder.startAt(startPosition);

        // then
        assertThat(lastPosition).isLessThan(ladder.size() - 1);
        assertThat(lastPosition).isGreaterThan(-1);
    }
}
