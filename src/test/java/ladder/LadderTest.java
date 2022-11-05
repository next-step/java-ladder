package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    @DisplayName("수평선 있으면 인덱스 바뀌고 없으면 안바뀜")
    void test1() {
        // given
        int ladderHeight = 1;
        int countOfPerson = 2;
        Ladder ladder = new Ladder(ladderHeight, countOfPerson);
        // when
        int index0 = ladder.findFinalIndexOf(0);
        int index1 = ladder.findFinalIndexOf(1);
        // then
        if (index0 == 0) {
            assertThat(index1).isEqualTo(1);
        } else {
            assertThat(index1).isEqualTo(0);
        }
    }

}
