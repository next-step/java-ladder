package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositiveNumberTest {

    @Test
    public void 할당한_value_를_반환() {
        int expected = 11;

        PositiveNumber p = PositiveNumber.from(expected);
        assertThat(p.value()).isEqualTo(expected);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 음수_할당시_Exception() {
        PositiveNumber.from(-1);
    }
}