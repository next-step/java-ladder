package ladder.domain;

import org.junit.Before;
import org.junit.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DirectionTypeTest {
    private BooleanGenerator booleanGenerator;

    @Before
    public void setUp() throws Exception {
        Level level = Level.findLevel("middle");
        this.booleanGenerator = new BooleanGeneratorWithLevel(level);
    }

    @Test
    public void init() {
        assertThat(DirectionType.of(true, false), is(DirectionType.of(true, false)));
    }

    @Test(expected = IllegalStateException.class)
    public void init_invalid() {
        DirectionType.of(TRUE, TRUE);
    }

    @Test
    public void next_random_true() {
        DirectionType next = DirectionType.first(TRUE).next(booleanGenerator);
        assertThat(next, is(DirectionType.of(TRUE, FALSE)));
    }

    @Test
    public void next_random_false() {
        for (int i = 0; i < 100; i++) {
            DirectionType.first(FALSE).next(booleanGenerator);
        }
    }

    @Test
    public void next_true() {
        DirectionType next = DirectionType.of(TRUE, FALSE).next(TRUE);
        assertThat(next, is(DirectionType.of(FALSE, TRUE)));
    }

    @Test
    public void next_false() {
        DirectionType next = DirectionType.of(FALSE, TRUE).next(FALSE);
        assertThat(next, is(DirectionType.of(TRUE, FALSE)));
    }

    @Test
    public void first() {
        DirectionType first = DirectionType.first(TRUE);
        assertThat(first.isLeft(), is(FALSE));
    }

    @Test
    public void last() {
        DirectionType last = DirectionType.first(TRUE).last();
        assertThat(last, is(DirectionType.of(TRUE, FALSE)));
    }
}