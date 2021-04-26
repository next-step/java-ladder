package step4.laddergame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SizeTest {
    private Size size;
    private int height = 5;
    private int width = 6;

    @Test
    void 높이를생성(){
        size = new Size(height, width);
        assertThat(size).isEqualTo(new Size(height, width));
    }

    @Test
    @DisplayName("높이는 10을 초과할 수 없다")
    void 높이초과() {
        assertThatThrownBy(() -> {
            new Size(11, 5);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
