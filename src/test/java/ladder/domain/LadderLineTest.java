package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static ladder.domain.LadderLine.PERSON_COUNT_MUST_MORE_THEN_TWO;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LadderLineTest {
    @DisplayName("생성")
    @Nested
    class Create {
        @DisplayName("성공")
        @Test
        void success() {
            // given
            final int personCount = 5;

            // when
            final LadderLine ladderLine = LadderLine.of(personCount);

            // then
            assertThat(ladderLine.size()).isEqualTo(personCount);
        }

        @DisplayName("2보다 작은 경우 실패")
        @Test
        void fail_when_person_count_less_then_two() {
            // given
            final int personCount = 0;

            // when 
            final Throwable thrown = catchThrowable(() -> {
                LadderLine.of(personCount);
            });

            // then
            Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(PERSON_COUNT_MUST_MORE_THEN_TWO);
        }
    }
}
