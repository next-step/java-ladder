package domain.ladder;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PairTest {

    @Test(expected = IllegalStateException.class)
    public void 양쪽사다리_생성_오류() {
        Pair pair = new Pair(Boolean.TRUE, Boolean.TRUE);
    }

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

    @Test
    public void generate_singlePair() {
        Pair pair = Pair.single();
        assertThat(pair.isLeft()).isFalse();
        assertThat(pair.isRight()).isFalse();
    }

    @Test
    public void 왼쪽으로_이동한_결과_구하기() {
        Pair pair = Pair.last(Boolean.TRUE);
        int current = 4;
        int next = pair.next(current);
        assertThat(next).isEqualTo(3);
    }

    @Test
    public void 오른쪽으로_이동한_결과_구하기() {
        Pair pair = Pair.middle(Boolean.FALSE, Boolean.TRUE);
        int current = 4;
        int next = pair.next(current);
        assertThat(next).isEqualTo(5);
    }

    @Test
    public void 그대로_내려간_결과_구하기() {
        Pair pair = Pair.middle(Boolean.FALSE, Boolean.FALSE);
        int current = 4;
        int next = pair.next(current);
        assertThat(next).isEqualTo(4);
    }
}
