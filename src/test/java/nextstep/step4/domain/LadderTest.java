package nextstep.step4.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class LadderTest {

    private Ladder ladder;

    @BeforeEach
    void setUp() {
        Point oneByOne = Point.first(true);
        Point oneByTwo = oneByOne.next(false);
        Point oneByThree = oneByTwo.last();

        Point twoByOne = Point.first(false);
        Point twoByTwo = twoByOne.next(true);
        Point twoByThree = twoByTwo.last();

        Point threeByOne = Point.first(true);
        Point threeByTwo = threeByOne.next(false);
        Point threeByThree = threeByTwo.last();

        Line firstLine = Line.from(Arrays.asList(oneByOne, oneByTwo, oneByThree));
        Line secondLine = Line.from(Arrays.asList(twoByOne, twoByTwo, twoByThree));
        Line thirdLine = Line.from(Arrays.asList(threeByOne, threeByTwo, threeByThree));

        ladder = new Ladder(Arrays.asList(firstLine, secondLine, thirdLine));
    }

    @ParameterizedTest
    @CsvSource(value = {"0:2", "1:1", "2:0"}, delimiter = ':')
    void findEndColumByStartColumn(int startColumn, int endColumn) {
        assertThat(ladder.findEndColumByStartColumn(startColumn)).isEqualTo(endColumn);
    }

    @Test
    void create() {
        Ladder ladder = Ladder.of(5, 5);
        assertThat(ladder.getLadder()).hasSize(5);
    }
}