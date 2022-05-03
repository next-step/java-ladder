package nextstep.ladder;

import nextstep.ladder.domain.Ladders;
import nextstep.ladder.domain.Line;
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

        defaultLadders = Ladders.getDefault(
                asList(firstLine, secondLine, thirdLine, fourthLine, fifthLine));
    }

    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:3", "2:2", "3:1"}, delimiter = ':')
    void playLadder(int startPosition, int endPosition) {
        int ladderResultPosition = defaultLadders.findLadderResult(startPosition);

        assertThat(ladderResultPosition).isEqualTo(endPosition);
    }
}