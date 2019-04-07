package domain.ladder;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PairTest {

    @Test
    public void check_true_false() {
        Pair pair = new Pair(Boolean.FALSE, Boolean.TRUE);
        assertThat(pair.isLeft()).isFalse();
        assertThat(pair.isRight()).isTrue();
    }

    @Test
    public void generateBrigde() {
        Pair pair = new Pair().make(Boolean.TRUE);
        assertThat(pair.isLeft()).isTrue();
        assertThat(pair.isRight()).isFalse();
    }
}
