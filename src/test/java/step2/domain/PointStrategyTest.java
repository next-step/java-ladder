package step2.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointStrategyTest {

    @Test
    void pointFalseStrategyTest() {
        final boolean actual = new PointFalseStrategy().create();
        final boolean expected = false;
        assertThat(actual).isEqualTo(expected);
    }

}