package nextstep.ladder.domain;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomRungStrategyTest {

    @Test
    public void rung이_항상_만들어지는_케이스() {
        List<Junction> junctions = Junction.createJunctions(3);

        Row row = new Row(junctions);

        RandomRungStrategy randomRungStrategy
            = new RandomRungStrategy(new BooleanStubRandom(true));

        row.applyRungs(randomRungStrategy);

        Junction j1 = row.getJunction(0);
        assertThat(j1.hasLeft()).isFalse();
        assertThat(j1.hasRight()).isTrue();
        assertThat(j1.hasConnect()).isTrue();

        Junction j2 = row.getJunction(1);
        assertThat(j2.hasLeft()).isTrue();
        assertThat(j2.hasRight()).isFalse();
        assertThat(j2.hasConnect()).isTrue();

        Junction j3 = row.getJunction(2);
        assertThat(j3.hasLeft()).isFalse();
        assertThat(j3.hasRight()).isFalse();
        assertThat(j3.hasConnect()).isFalse();


    }

    @Test
    public void rung이_항상_만들어지지_않는_케이스() {
        List<Junction> junctions = Junction.createJunctions(2);

        Row row = new Row(junctions);

        RandomRungStrategy randomRungStrategy
            = new RandomRungStrategy(new BooleanStubRandom(false));

        row.applyRungs(randomRungStrategy);

        Junction j1 = row.getJunction(0);
        assertThat(j1.hasLeft()).isFalse();
        assertThat(j1.hasRight()).isFalse();
        assertThat(j1.hasConnect()).isFalse();

        Junction j2 = row.getJunction(1);
        assertThat(j2.hasLeft()).isFalse();
        assertThat(j2.hasRight()).isFalse();
        assertThat(j2.hasConnect()).isFalse();
    }


}
