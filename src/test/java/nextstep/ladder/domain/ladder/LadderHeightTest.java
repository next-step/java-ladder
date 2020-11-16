package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사다리 높이 테스트")
public class LadderHeightTest {
    @DisplayName("사다리 높이 생성")
    @Test
    public void createLadderHeight() {
        LadderHeight ladderHeight = LadderHeight.of(5);

        int height = ladderHeight.getHeight();

        assertThat(height).isEqualTo(5);
    }

    @DisplayName("0이하 높이 생성")
    @ParameterizedTest
    @CsvSource(value = {"-1", "0"})
    public void createInvalidHeight(int invalidHeight) {
        assertThatThrownBy(() -> {
            LadderHeight.of(invalidHeight);
        }).isInstanceOf(InvalidLadderHeightException.class)
                .hasMessageContaining("사다리 높이는 1이상이어야 합니다.");
    }

    @DisplayName("사다리 높이 동등 비교")
    @Test
    public void equalsLadderHeight() {
        assertThat(LadderHeight.of(5)).isEqualTo(LadderHeight.of(5));
    }
}