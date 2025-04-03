package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RungTest {

    @Test
    void ConnectIfPossibleRungStrategy는_가능하다면_rung을_만든다() {
        int height = 5;

        List<Leg> legs
            = LegFactory.createLegs(Arrays.asList("test1", "test2", "test3"), height);
        Ladder ladder = new Ladder(legs);

        Leg leg1 = ladder.getLegs().get(0);
        Leg leg2 = ladder.getLegs().get(1);
        Leg leg3 = ladder.getLegs().get(2);

        ladder.createRungs(new ConnectIfPossibleRungStrategy());

        for (int i = 0; i < height; i++) {
            Junction junction1 = leg1.getJunction(i);
            assertThat(junction1.hasLeft()).isFalse();
            assertThat(junction1.hasRight()).isTrue();
            assertThat(junction1.hasConnect()).isTrue();

            Junction junction2 = leg2.getJunction(i);
            assertThat(junction2.hasLeft()).isTrue();
            assertThat(junction2.hasRight()).isFalse();
            assertThat(junction2.hasConnect()).isTrue();

            Junction junction3 = leg3.getJunction(i);
            assertThat(junction3.hasLeft()).isFalse();
            assertThat(junction3.hasRight()).isFalse();
            assertThat(junction3.hasConnect()).isFalse();
        }
    }

    @Test
    void NoConnectRungStrategy는_rung을_만들지_않는다() {
        int height = 5;

        List<Leg> legs = LegFactory.createLegs(Arrays.asList("test1", "test2"), height);
        Ladder ladder = new Ladder(legs);

        Leg leg1 = ladder.getLegs().get(0);
        Leg leg2 = ladder.getLegs().get(1);

        ladder.createRungs(new NoConnectRungStrategy());

        for (int i = 0; i < height; i++) {
            Junction junction1 = leg1.getJunction(i);
            assertThat(junction1.hasLeft()).isFalse();
            assertThat(junction1.hasRight()).isFalse();
            assertThat(junction1.hasConnect()).isFalse();

            Junction junction2 = leg2.getJunction(i);
            assertThat(junction2.hasLeft()).isFalse();
            assertThat(junction2.hasRight()).isFalse();
            assertThat(junction2.hasConnect()).isFalse();
        }
    }

}
