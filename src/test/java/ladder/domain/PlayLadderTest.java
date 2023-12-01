package ladder.domain;

import ladder.strategy.RandomPathStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayLadderTest {

    @Test
    @DisplayName("참가자 수와 당첨 결과 수는 같아야 한다. 같지 않을 시 예외가 발생한다.")
    public void validate_count_of_Players_and_prizes(){
        Assertions.assertThatThrownBy(() -> PlayLadder.of(Players.of("1", "2"),
                Prizes.of("a", "bb", "ccc"),
                Ladder.of(2, 3, new RandomPathStrategy()))
                ).isInstanceOf(IllegalArgumentException.class);
    }
}
