package ladderinterface.concrete;

import ladderinterface.engine.Line;
import ladderinterface.fixture.TestLadderFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.assertj.core.api.Assertions.assertThat;


public class LadderLineTest {

    @ParameterizedTest
    @CsvSource({"0,1", "1,0", "2,3", "3,2", "4,4"})
    void move(int input, int expected) {
        Line ladderLine = TestLadderFactory.createLine(true, false, true, false, false);
        assertThat(ladderLine.move(input)).isEqualTo(expected);
    }
}
