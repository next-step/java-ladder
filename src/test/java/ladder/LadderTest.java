package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    @DisplayName("수평선이 없을 경우 최종 결과")
    void test1() {
        // given
        int ladderHeight = 1;
        int countOfPerson = 2;
        Ladder ladder = new Ladder(ladderHeight, countOfPerson, () -> false);
        // when
        int index0 = ladder.findFinalIndexOf(0);
        int index1 = ladder.findFinalIndexOf(1);
        // then
        assertThat(index0).isEqualTo(0);
        assertThat(index1).isEqualTo(1);
    }

    @Test
    @DisplayName("수평선이 있을 경우 최종 결과")
    void test2() {
        // given
        int ladderHeight = 1;
        int countOfPerson = 2;
        Ladder ladder = new Ladder(ladderHeight, countOfPerson, () -> true);
        // when
        int index0 = ladder.findFinalIndexOf(0);
        int index1 = ladder.findFinalIndexOf(1);
        // then
        assertThat(index0).isEqualTo(1);
        assertThat(index1).isEqualTo(0);
    }

}
