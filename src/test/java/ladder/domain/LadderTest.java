package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("width가 4, height가 5인 사다리를 생성한다.")
    void should_return_ladder() {
        //Given
        LadderSize ladderSize = new LadderSize(4, 5);

        //When
        Ladder ladder = new Ladder(ladderSize);

        //Then
        assertThat(ladder.getLadderWidth()).isEqualTo(4);
        assertThat(ladder.getLadderLines().size()).isEqualTo(5);

    }
}
