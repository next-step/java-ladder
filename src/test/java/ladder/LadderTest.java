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

    @Test
    @DisplayName("개인별 결과를 알 수 있다.")
    void canKnowResultPerPerson() {
        int countOfPerson = 2;
        int height = 3;
        Ladder ladder = new Ladder(countOfPerson, height);
        ladder.drawLine(() -> true);

        int startIndex = 0;
        int resultIndex = ladder.result(startIndex);

        Assertions.assertThat(resultIndex).isEqualTo(1);
    }
}
