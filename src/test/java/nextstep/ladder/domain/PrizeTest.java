package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PrizeTest {

    @ParameterizedTest(name = "Prize 비어있을 수 없다.")
    @NullAndEmptySource
    @ValueSource(strings = " ")
    void validation(String invalidPrize) {
        assertThatThrownBy(() -> new Prize(invalidPrize))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void equals() {
        assertThat(new Prize("3")).isEqualTo(new Prize("3"));
    }
}
