package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchIndexOutOfBoundsException;

class LegTest {

    @Test
    void leg_name_height_테스트() {
        String name = "이름";
        int height = 5;

        Leg leg = new Leg(name, height);

        assertThat(leg.getName()).isEqualTo(name);
        assertThat(leg.getHeight()).isEqualTo(height);
    }

    @Test
    void height_만큼_junction이_생성된다() {
        String name = "이름";
        int height = 5;

        Leg leg = new Leg(name, height);

        for (int i = 0; i < height; i++) {
            assertThat(leg.getJunction(i)).isNotNull();
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -99})
    void height가_음수이거나_0이면_leg의_height는_0이다(int height) {
        Leg leg = new Leg("next", height);

        assertThat(leg.getHeight()).isEqualTo(0);
    }

    @Test
    void ladder의_height를_벗어나는_junction을_가져오면_예외가_발생한다() {
        String name = "이름";
        int height = 5;

        Leg leg = new Leg(name, height);

        IndexOutOfBoundsException e = catchIndexOutOfBoundsException(() -> leg.getJunction(height));

        assertThat(e).isNotNull();
    }

}
