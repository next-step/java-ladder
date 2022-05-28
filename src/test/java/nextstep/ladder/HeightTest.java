package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HeightTest {
    @DisplayName("사다리 높이는 1칸 이상이다.")
    @ValueSource(ints = {-1, 0})
    @ParameterizedTest
    public void min_height(int height) {
        assertThatThrownBy(() -> new Height(height))
                .isInstanceOf(InvalidHeightException.class);
    }

    @DisplayName("사다리 높이 생성")
    @Test
    public void create() {
        final Height height = new Height(5);
        assertThat(height).isNotNull();
    }
}
