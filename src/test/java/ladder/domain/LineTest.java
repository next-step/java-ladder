package ladder.domain;

import ladder.strategy.RandomPathStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    @DisplayName("입력 받은 수 만큼 경로를 생성한다. 경로는 최소 2개 이상이어야 한다.")
    void create(){
        Assertions.assertThatThrownBy(() -> {
            Line.of(1, new RandomPathStrategy());
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
