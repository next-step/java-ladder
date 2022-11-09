package ladder.domain;

import ladder.domain.ladder.LadderHeight;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderHeightTest {

    @Test
    @DisplayName("높이가 0인 값이 들어왔을 때 예외 처리 확인")
    void testExceptionIfZeroHeight(){
        Assertions.assertThatThrownBy(() -> new LadderHeight(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("height must be bigger than 0");
    }
}
