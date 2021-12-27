package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {

    @DisplayName("유효한 height과 width로 Ladder 생성할 경우, 정상적으로 Ladder 인스턴스가 생성된다.")
    @Test
    void create() {
        int width = 7;
        int height = 5;
        Ladder ladder = new Ladder(width, height);

        assertThat(ladder.width()).isEqualTo(width);
        assertThat(ladder.height()).isEqualTo(height);
    }

    @DisplayName("Names로 Ladder 생성. ,로 구분한다.")
    @Test
    void create_names() {
        int height = 5;
        Ladder ladder = new Ladder(new Names("pobi, honux, crong, jk"), height);

        assertThat(ladder.width()).isEqualTo(7);
        assertThat(ladder.height()).isEqualTo(height);
    }

    @DisplayName("width와 height은 음수일 수 없다.")
    @ParameterizedTest
    @CsvSource(value = {"-1,1", "1,-1"})
    void invalid_width(int width, int height) {
        assertThatThrownBy(() -> new Ladder(width, height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Ladder.INVALID_WIDTH_HEIGHT_MESSAGE);
    }
}
