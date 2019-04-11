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
    public void generate_firstPair() {
        Pair pair = Pair.first(Boolean.TRUE);
        assertThat(pair.isLeft()).isFalse();
        assertThat(pair.isRight()).isTrue();
    }

    @Test
    public void generate_lastPair() {
        Pair pair = Pair.last(Boolean.FALSE);
        assertThat(pair.isLeft()).isFalse();
        assertThat(pair.isRight()).isFalse();
    }

    @Test
    public void generate_middlePair() {
        Pair pair = Pair.middle(Boolean.FALSE, Boolean.TRUE);
        assertThat(pair.isLeft()).isFalse();
        assertThat(pair.isRight()).isTrue();
    }
}
