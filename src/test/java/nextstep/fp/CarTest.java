package nextstep.fp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    public void 이동() {
        assertThat(new Car("pobi", 0).move(() -> true)).isEqualTo(new Car("pobi", 1));
    }

    @Test
    public void 정지() {
        assertThat(new Car("pobi", 0).move(() -> false)).isEqualTo(new Car("pobi", 0));
    }
}
