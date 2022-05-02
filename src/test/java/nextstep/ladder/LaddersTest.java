package nextstep.ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static java.util.Arrays.*;
import static org.assertj.core.api.Assertions.*;

class LaddersTest {

    private Ladders defaultLadders;

    @BeforeEach
    void setUp() {
        Line firstLine = new Line(asList(true, false, true, false));
        Line secondLine = new Line(asList(false, true, false, false));
        Line thirdLine = new Line(asList(true, false, false, false));
        Line fourthLine = new Line(asList(false, true, false, false));
        Line fifthLine = new Line(asList(true, false, true, false));

        String[] results = {"꽝", "5000", "꽝", "3000"};

        defaultLadders = Ladders.makeDefaultLadders(asList(firstLine, secondLine, thirdLine, fourthLine, fifthLine), LaddersResults.makeLaddersResultsByUserInput(results));
    }

    @ParameterizedTest
    @CsvSource(value = {"0:꽝", "1:3000", "2:꽝", "3:5000"}, delimiter = ':')
    void playLadder(int startPosition, String endResult) {
        String ladderResult = defaultLadders.findLadderResult(startPosition);
        assertThat(ladderResult).isEqualTo(endResult);
    }
}