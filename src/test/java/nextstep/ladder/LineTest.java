package nextstep.ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    private int countOfPerson;

    @BeforeEach
    void setUp() {
        countOfPerson = 5;
    }

    @Test
    void testLineTruePoints() {

        Line n = new Line(countOfPerson, a -> true);
        assertThat(n.getPoints()).containsExactly(true, true, true, true, true);

    }

    @Test
    void testLineAllFalsePoints() {
        Line n = new Line(countOfPerson, a -> false);
        assertThat(n.getPoints()).containsExactly(false, false, false, false, false);
    }

    @Test
    void testNotSequenceTruePoints() {
        Line n = new Line(countOfPerson, new RandomBooleanFunction());
        assertThat(n.getPoints()).doesNotContainSequence(true, true);
    }


}
