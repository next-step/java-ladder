package game.ladder.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpectsTest {

    @Test
    public void 만들기() {
        final List<Expect> list = Arrays.asList(new Expect("a"), new Expect("b"));

        Expects expects = new Expects(list);

        assertThat(expects.size()).isEqualTo(list.size());
    }

    @Test
    public void 예상결과_꺼내기() {
        final Expect first = new Expect("first");
        final Expect second = new Expect("second");
        final List<Expect> list = Arrays.asList(first, second);
        Expects expects = new Expects(list);

        Expect expect1 = expects.getExpect(new Position(1));
        Expect expect2 = expects.getExpect(new Position(2));

        assertThat(expect1).isSameAs(first);
        assertThat(expect2).isSameAs(second);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 없는_예상값_꺼내기() {
        final Expect first = new Expect("first");
        final Expect second = new Expect("second");
        final List<Expect> list = Arrays.asList(first, second);
        Expects expects = new Expects(list);

        expects.getExpect(new Position(3));
    }

    @Test
    public void getStringExpects() {
        final String expect = "     꽝    당첨";
        Expects expects = new Expects(Arrays.asList(new Expect("꽝"), new Expect("당첨")));
        assertThat(expects.getStringExpects()).isEqualTo(expect);
    }
}