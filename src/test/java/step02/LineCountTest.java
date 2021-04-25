package step02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step02.ladder.LineCount;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineCountTest {

    @Test
    @DisplayName("높이가 0 입력 테스트")
    void checkZeroLine() {
        assertThatThrownBy(() -> {
            LineCount.checkZeroLine(0);
        }).isInstanceOf(IllegalAccessException.class)
                .hasMessage("사다리는 높이 0이상으로 입력해주세요.");
    }
}
