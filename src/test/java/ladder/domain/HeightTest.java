package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HeightTest {

    @Test
    @DisplayName("높이는 1 이상이어야 한다.")
    void createHeight(){
        assertThatThrownBy(() -> new Height(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("높이는 1 이상이어야 합니다.");
    }
}
