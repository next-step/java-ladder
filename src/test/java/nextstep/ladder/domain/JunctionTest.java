package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JunctionTest {

    @Test
    public void junction은_오른쪽으로_연결할_수_있다() {
        Junction junction = new Junction();
        Junction rightJunction = new Junction();

        junction.connectRight(rightJunction);

        assertThat(junction.hasLeft()).isFalse();
        assertThat(junction.hasRight()).isTrue();
        assertThat(junction.hasConnect()).isTrue();
        assertThat(rightJunction.hasLeft()).isTrue();
        assertThat(rightJunction.hasRight()).isFalse();
        assertThat(rightJunction.hasConnect()).isTrue();
    }

}
