package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {

    @DisplayName("Ladder는 height과 width를 가진다.")
    @Test
    void create() {
        int width = 7;
        int height = 5;
        Ladder ladder = new Ladder(width, height);

        assertThat(ladder.width()).isEqualTo(width);
        assertThat(ladder.height()).isEqualTo(height);
    }

    @DisplayName("Names로 생성")
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
                .hasMessage("width와 height는 음수일수 없습니다.");
    }

}
