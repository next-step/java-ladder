package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.ladder.factory.FixedWayRule;
import nextstep.ladder.domain.ladder.size.LadderWidth;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    /**
     * 0    1    2    3    4    5
     * |----|    |----|    |----|
     * |    |----|    |----|    |
     * |    |----|    |    |----|
     * |    |    |----|    |----|
     * 0    1    2    3    4    5
     */
    @DisplayName("결과를 잘 반환하는지")
    @ParameterizedTest(name = "[{index}] startIndex: {0}, endIndex: {1}")
    @CsvSource({
            "0, 1",
            "1, 0",
            "2, 4",
            "3, 3",
            "4, 5",
            "5, 2"
    })
    void move(int startIndex, int expectedIndex) {
        //given
        int width = 6;
        LadderLine first = ladderLine(width, asList(true, false, true, false, true));
        LadderLine second = ladderLine(width, asList(false, true, false, true, false));
        LadderLine third = ladderLine(width, asList(false, true, false, false, true));
        LadderLine fourth = ladderLine(width, asList(false, false, true, false, true));

        //when
        Ladder ladder = new Ladder(asList(first, second, third, fourth));

        //then
        assertThat(ladder.move(startIndex)).isEqualTo(expectedIndex);
    }

    private LadderLine ladderLine(int width, List<Boolean> creations) {
        return LadderLine.of(new LadderWidth(width), new FixedWayRule(creations));
    }

}
