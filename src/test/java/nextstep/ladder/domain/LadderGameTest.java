package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    @Test
    @DisplayName("생성할 사다리 수 의 값과 생성된 사다리의 size가 맞는지 확인한다.")
    void size() {
        int expectSize = 5;
        int height = 5;
        Ladders ladders = LadderGame.newInstance(expectSize, height);

        assertThat(ladders.size()).isEqualTo(expectSize);
        assertThat(ladders.height()).isEqualTo(height);
    }
}
