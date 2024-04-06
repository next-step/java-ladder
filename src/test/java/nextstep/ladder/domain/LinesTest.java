package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LinesTest {

    @DisplayName("사다리 높이는 1 이상이어야 한다.")
    @Test
    void invalidHeight() {
        assertThatThrownBy(() -> Lines.of(3, 0)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("참여자 수와 사다리 높이를 받아 사다리를 생성한다.")
    @Test
    void create() {
        int height = 5;
        int numberOfPlayers = 3;
        Lines lines = Lines.of(numberOfPlayers, height);

        assertThat(lines.getHeight()).isEqualTo(height);
    }
}
