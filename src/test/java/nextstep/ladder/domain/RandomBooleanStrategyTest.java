package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomBooleanStrategyTest {

    @DisplayName("매개변수가 true 면 false를 리턴한다.")
    @Test
    void value() {
        assertThat(new RandomBooleanStrategy().value(true)).isFalse();
    }
}
