package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static ladder.domain.Prize.PRIZE_NAME_LENGTH_MUST_BE_FIVE_OR_LESS;
import static ladder.domain.Prize.PRIZE_NAME_MUST_NOT_BE_BLANK;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class PrizeTest {
    @DisplayName("정적 팩터리 메서드를 이용한 생성")
    @Test
    void of() {
        // given
        final String prizeName = "5000";

        // when 
        final Prize prize = Prize.of(prizeName);

        // then
        assertThat(prize).isNotNull();
    }

    @DisplayName("5글자를 넘는 상품 이름이 전달 된 경우 예외 반환")
    @Test
    void of_throw_exception_when_prize_name_length_is_grate_then_five() {
        // given
        final String prizeName = "123456";

        // when 
        final Throwable thrown = catchThrowable(() -> {
            Prize.of(prizeName);
        });

        // then
        Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PRIZE_NAME_LENGTH_MUST_BE_FIVE_OR_LESS);
    }

    @DisplayName("상품 이름이 'blnak'로 전달 된 경우 예외 반환")
    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void of_throw_exception_when_prize_name_is_blank(final String prizeName) {
        // when 
        final Throwable thrown = catchThrowable(() -> {
            Prize.of(prizeName);
        });

        // then
        Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PRIZE_NAME_MUST_NOT_BE_BLANK);
    }
}
