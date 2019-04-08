package ladder.vo.coordinate;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class CoordinateValueTest {
    @Test
    public void 좌표값은_0_미만일_경우_IllegalArgumentException() {
        // given
        int coordinateValue = -1;

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new CoordinateValue(coordinateValue));
    }

    @Test
    public void 좌표값_증가() {
        // given
        int value = 0;
        CoordinateValue coordinateValue = new CoordinateValue(value);

        // when
        CoordinateValue incrementedCoordinateValue = coordinateValue.increment();

        // then
        assertThat(incrementedCoordinateValue).isEqualTo(new CoordinateValue(value + 1));
    }

    @Test
    public void 좌표값_감소() {
        // given
        int value = 1;
        CoordinateValue coordinateValue = new CoordinateValue(value);

        // when
        CoordinateValue incrementedCoordinateValue = coordinateValue.decrement();

        // then
        assertThat(incrementedCoordinateValue).isEqualTo(new CoordinateValue(value - 1));
    }

    @Test
    public void 좌표값_감소_시_0_미만이_될_경우_IllegalStateException() {
        // given
        int value = 0;
        CoordinateValue coordinateValue = new CoordinateValue(value);

        // when
        // then
        assertThatIllegalStateException().isThrownBy(() -> coordinateValue.decrement());
    }
}
