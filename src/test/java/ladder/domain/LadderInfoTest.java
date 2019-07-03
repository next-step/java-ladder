package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderInfoTest {

    @Test
    @DisplayName("생성된 사다리 너비, 길이 검증")
    void of() {

        int width = 4;
        int height = 5;
        LadderInfo ladderInfo = LadderInfo.of(width, height);

        assertThat(ladderInfo.getWidth()).isEqualTo(width);
        assertThat(ladderInfo.getHeight()).isEqualTo(height);
    }

    @ParameterizedTest(name = "사다리 생성시 너비나 길이가 유효하지 않다면 exception 발생")
    @CsvSource(value = {
            "1,5",
            "4,0"
    })
    void ofException(int width, int height) {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderInfo.of(width, height));
    }
}