package ladder;

import ladder.domain.Ladder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    @DisplayName("입력된 높이만큼의 사다리를 생성한다.")
    void ladderHeight() {
        int countOfPerson = 4;
        int height = 5;
        Ladder ladder = new Ladder(countOfPerson, height);
        Assertions.assertThat(ladder.getLadder().size()).isEqualTo(5);
    }
}
