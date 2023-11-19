package ladder;

import ladder.domain.Height;
import ladder.exception.NegativeHeightException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class HeightTest {

    @Test
    @DisplayName("사다리 높이가 음수일 경우 에러 발생한다")
    public void height_negative() {
        assertThatExceptionOfType(NegativeHeightException.class)
            .isThrownBy(() -> {
                new Height(-1);
            }).withMessageMatching("사다리 높이는 음수일 수 없습니다");
    }

}
