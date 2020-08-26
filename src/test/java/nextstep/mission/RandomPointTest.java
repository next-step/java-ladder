package nextstep.mission;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomPointTest {

    @Test
    void next() {
        assertThat(new RandomPoint(true).next()).isFalse();
    }
}
