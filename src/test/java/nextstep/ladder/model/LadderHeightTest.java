package nextstep.ladder.model;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderHeightTest {

    @Test
    @DisplayName("사다리의 높의는 1 이상이다")
    void ladder_height() {
        Assertions.assertThatThrownBy(() -> {
            new LadderHeight(0);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("높이는 1 이상 이어야 합니다.");

        Assertions.assertThatThrownBy(() -> {
                new LadderHeight(-1);
            }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("높이는 1 이상 이어야 합니다.");
    }
}