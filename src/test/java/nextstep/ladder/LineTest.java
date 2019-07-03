package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    private int countOfPerson = 5;
    private Line line;

    @Test
    void testAllTruePointsWhenTrue() {
        line = new Line(countOfPerson, a -> true);
        assertThat(line.getPoints()).containsExactly(true, true, true, true, true);
    }

    @Test
    void testAllFalsePointsWhenTrue() {
        line = new Line(countOfPerson, a -> false);
        assertThat(line.getPoints()).containsExactly(false, false, false, false, false);
    }

    @Test
    void testNotTruePointsInOrderWhenRandomBoolean() {
        Line n = new Line(countOfPerson, new RandomBooleanFunction());
        assertThat(n.getPoints()).doesNotContainSequence(true, true);
    }
}
