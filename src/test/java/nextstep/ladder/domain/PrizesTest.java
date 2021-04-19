package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.Test;

class PrizesTest {
    @Test
    void create() {
        assertThatCode(() -> Prizes.of("꽝,5000,꽝,3000")).doesNotThrowAnyException();
    }

    @Test
    void findByIndex() {
        assertThat(Prizes.of("꽝,5000,꽝,3000").findByIndex(0)).isEqualToComparingFieldByField(Prize.of("꽝"));
    }
}