package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.position.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static java.util.Arrays.asList;
import static java.util.Collections.nCopies;
import static nextstep.ladder.domain.factory.NoPointRule.noPointRule;
import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("정상생성")
    @Test
    void create() {
        //given
        int width = 5;
        LadderSize ladderSize = new LadderSize(new Positive(3), new Positive(width));

        //when
        Ladder ladder = Ladder.of(ladderSize, noPointRule());

        //then
        Line expectedLine = new Line(asList(false, false, false));
        assertThat(ladder).isEqualTo(new Ladder(nCopies(width, expectedLine)));
    }

    /**
     * 사다리 모양
     * 0     1     2     3     4
     * |-----|     |-----|     |
     * |     |-----|     |-----|
     * |     |     |-----|     |
     * |-----|     |-----|     |
     * |-----|     |     |     |
     */
    @DisplayName("게임이 잘 진행되는지")
    @ParameterizedTest(name = "[{index}] startPosition: {0}, expectedPosition: {1}")
    @CsvSource({
            "0, 2",
            "1, 0",
            "2, 4",
            "3, 1",
            "4, 3",
    })
    void play(int startPosition, int expectedPosition) {
        Line first = new Line(asList(true, false, true, false));
        Line second = new Line(asList(false, true, false, true));
        Line third = new Line(asList(false, false, true, false));
        Line fourth = new Line(asList(true, false, true, false));
        Line fifth = new Line(asList(true, false, false, false));
        Ladder ladder = new Ladder(asList(first, second, third, fourth, fifth));

        Position position = ladder.play(new Position(startPosition));
        assertThat(position).isEqualTo(new Position(expectedPosition));
    }

}
