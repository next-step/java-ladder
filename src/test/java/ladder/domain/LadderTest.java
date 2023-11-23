package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderTest {

    @Test
    @DisplayName("사다리의 높이를 5로 지정할 경우 사다리의 Line은 5개가 생성된다.")
    void createLadder() {
        int totalLineCount = 5;
        int joinMemberCount = 4;

        Ladder ladder = new Ladder(totalLineCount, joinMemberCount, () -> true);

        assertThat(ladder.getLines()).hasSize(5);
    }

    @ParameterizedTest(name = "2명의 참가자와 1줄의 사다리(false, true)가 있을 경우 {0}번째 사람의 최종 포지션은 {1}이다.")
    @CsvSource(value = {"0, 1","1,0"})
    void ladderMove(int userIndex, int expected) {
        Ladder ladder = new Ladder(1, 2, () -> true);

        assertThat(ladder.ladderMove(userIndex)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "사다리의 높이를 {0} 으로 생성시 오류가 발생한다.")
    @ValueSource(ints = {0, -1})
    void createLadder_0_음수(int totalLineCount) {
        int joinMemberCount = 4;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Ladder(totalLineCount, joinMemberCount, () -> true))
                .withMessage("최대 사다리 높이는 0개 이하로 생성할 수 없습니다.");
    }
}
