package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderLineTest {

    @Test
    @DisplayName("입력받은 참가자 수에 맞는 길이를 가진 사다리를 생성한다.")
    void should_return_ladder() {
        //Given & When
        LadderLine ladderLine = new LadderLine(5);

        //Then
        assertThat(ladderLine.getPoints().size()).isEqualTo(9);
    }

    @Test
    @DisplayName("연속되지 않는 사다리를 생성한다.")
    void should_return_non_continuous_points() {
        //Given & Whens
        LadderLine ladderLine = new LadderLine(5);

        //Then
        for (int index = 3; index < ladderLine.getPoints().size(); index += 2) {
            boolean previous = ladderLine.getPoints().get(index - 2);
            boolean current = ladderLine.getPoints().get(index);
            assertThat(previous && current).isFalse();
        }
    }

}
