package ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    @DisplayName("사다리의 높이는 5로 설계한다.")
    void ladderHeight_5() {
        int countOfPerson = 4;
        Ladder ladder = new Ladder(countOfPerson);
        Assertions.assertThat(ladder.getLadder().size()).isEqualTo(5);
    }
}
