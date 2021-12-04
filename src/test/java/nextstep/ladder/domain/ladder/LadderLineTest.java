package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.exception.OutOfRangeIndexException;
import nextstep.ladder.domain.rule.WayRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderLineTest {

    // 0    1    2    3
    // |----|    |----|
    @ParameterizedTest(name = "[{index}] startIndex: {0}, movedIndex: {1}")
    @CsvSource({
            "0, 1",
            "1, 0",
            "2, 3",
            "3, 2",
    })
    void move(int startIndex, int movedIndex) {
        LadderLine ladderLine = LadderLine.of(new LadderWidth(4), createWayRule());
        assertThat(ladderLine.move(startIndex)).isEqualTo(movedIndex);
    }

    private static WayRule createWayRule() {
        return () -> true;
    }

    @DisplayName("startIndex가 0미만이거나 사다리폭 이상이라면 예외를 던진다.")
    @ParameterizedTest(name = "[{index}] width: {0}, startIndex: {1}")
    @CsvSource({
            "4, -1",
            "5, 5",
            "100, 101",
    })
    void move_outOfRangeIndex_throwsException(int width, int startIndex) {
        LadderLine ladderLine = LadderLine.of(new LadderWidth(width), () -> false);
        assertThatThrownBy(() -> ladderLine.move(startIndex))
                .isInstanceOf(OutOfRangeIndexException.class);
    }

}
