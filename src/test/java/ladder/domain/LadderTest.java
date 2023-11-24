package ladder.domain;

import ladder.strategy.RandomPathStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LadderTest {

    @Test
    @DisplayName("입력 받은 수 만큼 사다리를 생성한다. 최소 높이는 2개 이상이어야 한다.")
    public void create(){
        Ladder ladder = Ladder.of(2, 2,  size -> List.of(true, false));
        Assertions.assertThat(ladder).isEqualTo(Ladder.of(2, 2,  size -> List.of(true, false)));
        Assertions.assertThat(ladder).isNotEqualTo(Ladder.of(3, 3,  size -> List.of(true, false, true)));

        Assertions.assertThatThrownBy(() -> Ladder.of(1,10, new RandomPathStrategy())).isInstanceOf(IllegalArgumentException.class);
    }
}
