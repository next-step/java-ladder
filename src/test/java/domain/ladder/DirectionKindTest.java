package domain.ladder;

import org.junit.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DirectionKindTest {

    @Test
    public void 객체찾기() {
        assertThat(DirectionKind.findDirection(TRUE, FALSE).getDirection(), is(Direction.of(TRUE, FALSE)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 객체오류() {
        DirectionKind.findDirection(TRUE, TRUE);
    }
}