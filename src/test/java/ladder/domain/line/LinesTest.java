package ladder.domain.line;

import ladder.domain.data.LineData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LinesTest {

    @DisplayName("null 입력 예외 발생")
    @Test
    void createNull() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Lines.create(null));
    }

    @DisplayName("lines를 수정하면 예외 발생")
    @Test
    void getLines() {
        Lines lines = Lines.create(LineData.makeRandom(2));

        assertThatThrownBy(() -> lines.getLines().remove(0))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
