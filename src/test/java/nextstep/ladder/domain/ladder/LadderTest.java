package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.direction.Point;
import nextstep.ladder.util.StringSplitter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    void create() {
        Ladder ladder = Ladder.of(5, 4);

        assertThat(ladder.ladderLines().size()).isEqualTo(5);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "RIGHT_DOWN,LEFT_DOWN,RIGHT_DOWN,LEFT_DOWN,DOWN:RIGHT_DOWN,LEFT_DOWN,RIGHT_DOWN,LEFT_DOWN,DOWN:" +
                    "RIGHT_DOWN,LEFT_DOWN,DOWN,RIGHT_DOWN,LEFT_DOWN:RIGHT_DOWN,LEFT_DOWN,DOWN,RIGHT_DOWN,LEFT_DOWN:" +
                    "0,1,2,3,4",
            "RIGHT_DOWN,LEFT_DOWN,RIGHT_DOWN,LEFT_DOWN,DOWN:RIGHT_DOWN,LEFT_DOWN,DOWN,RIGHT_DOWN,LEFT_DOWN:" +
                    "RIGHT_DOWN,LEFT_DOWN,RIGHT_DOWN,LEFT_DOWN,DOWN:RIGHT_DOWN,LEFT_DOWN,DOWN,RIGHT_DOWN,LEFT_DOWN:" +
                    "0,1,3,4,2"
    }, delimiter = ':')
    void applyLadderResultToListFromPlayResultOfAllLadderLines(
            String ladderLine1,
            String ladderLine2,
            String ladderLine3,
            String ladderLine4,
            String result
    ) {
        Ladder ladder = new Ladder(List.of(
                toLadderLine(ladderLine1),
                toLadderLine(ladderLine2),
                toLadderLine(ladderLine3),
                toLadderLine(ladderLine4)));

        List<Point> resultPoint = new StringSplitter(result)
                .indexBasedConverter((index, toParseInt) -> Point.from(Integer.parseInt(toParseInt), 4));

        IntStream.range(0, 5).forEach(i ->{
                    Point afterPoint = ladder.play(Point.from(i, 0));
                    assertThat(afterPoint).isEqualTo(resultPoint.get(i));
                });
    }

    private LadderLine toLadderLine(String text) {
        return new LadderLine(LadderLineTest.toDirections(text));
    }
}
