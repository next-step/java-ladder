package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class JunctionTest {

    @Test
    public void junction은_오른쪽으로_연결할_수_있다() {
        Junction junction = new Junction();
        Junction rightJunction = new Junction();

        assertThat(junction.hasLeft()).isFalse();
        assertThat(junction.hasRight()).isFalse();
        assertThat(junction.hasConnect()).isFalse();
        assertThat(rightJunction.hasLeft()).isFalse();
        assertThat(rightJunction.hasRight()).isFalse();
        assertThat(rightJunction.hasConnect()).isFalse();

        junction.connectRight(rightJunction);

        assertThat(junction.hasLeft()).isFalse();
        assertThat(junction.hasRight()).isTrue();
        assertThat(junction.hasConnect()).isTrue();
        assertThat(rightJunction.hasLeft()).isTrue();
        assertThat(rightJunction.hasRight()).isFalse();
        assertThat(rightJunction.hasConnect()).isTrue();
    }

}
