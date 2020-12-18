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
        assertThat(ladderLine.getPoints().size()).isEqualTo(5);
    }

}
