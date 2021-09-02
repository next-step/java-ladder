package step4.ladderGame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@SuppressWarnings("NonAsciiCharacters")
class HeightTest {

    @DisplayName("생성")
    @Test
    void create() {
        assertThat(new Height(5)).isInstanceOf(Height.class);
    }

    @DisplayName("높이가 1 미만일 경우 에러발생")
    @Test
    void validate_높이가_1미만일_경우_에러() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Height(0);
        }).withMessageMatching("사다리 높이는 1 이상이어야 합니다.");
    }

    @DisplayName("생성한 높이 반환")
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10, 20})
    void getHeight(int input) {
        Height height = new Height(input);
        assertThat(height.getValue()).isEqualTo(input);
    }

}
