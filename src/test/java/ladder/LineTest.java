package ladder;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    @DisplayName("유효하다면 성공적으로 생성된다")
    void success() {
        List<Boolean> input = List.of(false, true, false, false, false);
        assertThatNoException()
            .isThrownBy(() -> Line.of(input));
    }

    @Test
    @DisplayName("가로 라인이 겹칠 경우 예외가 발생한다")
    void fail_for_overlap() {
        List<Boolean> input = List.of(false, true, false, true, false);
        assertThatThrownBy(() -> Line.of(input))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("참가자 열이 true가 들어갈 경우 예외가 발생한다")
    void fail_for_participant_column_true() {
        List<Boolean> input = List.of(false, true, true, false, false);
        assertThatThrownBy(() -> Line.of(input))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
