package domain.ladder;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomPointTest {

    @Test
    public void 랜덤포인트_개수() {
        assertThat(new RandomPoint().getRandomPoint(5)).hasSize(4);
    }
}