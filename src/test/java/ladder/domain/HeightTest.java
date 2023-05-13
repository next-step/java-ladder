package ladder.domain;

import ladder.domain2.Height;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HeightTest {
    @ParameterizedTest(name = "높이가 {0}인 경우 생성")
    @ValueSource(ints = {1, 2, 3, 4, 5, 10, 20, 30})
    @DisplayName("높이 생성")
    void create(int heightInt) {
        // given
        ladder.domain2.Height height = new ladder.domain2.Height(heightInt);

        // then
        assertThat(height).isEqualTo(new ladder.domain2.Height(heightInt));
        assertThat(height.getHeight()).isEqualTo(heightInt);
    }

    @ParameterizedTest(name = "높이가 {0}인 경우 에러")
    @ValueSource(ints = {-1, 0, 31})
    @DisplayName("높이가 최소, 최대 범위 이외인 경우 에러")
    void createError(int heightInt) {
        // then
        assertThatThrownBy(() -> {
            new Height(heightInt);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 높이는 1이상 30이하만 가능합니다.");
    }

}