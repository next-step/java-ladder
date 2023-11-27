package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HeightTest {
    private static final int MIN_HEIGHT = 1;
    
    @Test
    @DisplayName("Height 는 최소 높이보다 낮은 높이가 주어지면 예외를 던진다.")
    void newObject_moreThanMinHeight_throwsException() {
        assertThatThrownBy(
                () -> new Height(MIN_HEIGHT)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
