package ladder.line;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.List;
import ladder.exception.InvalidCountOfPersonException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    @DisplayName("사다리 바 그리기 룰 검증")
    void init_line() {
        Line line1 = new ManualLine(4, List.of(false, true, false, true));
        Line line2 = new ManualLine(4, List.of(false, true, true, false));
        Line line3 = new ManualLine(4, List.of(true, false, true, false));
        Line line4 = new ManualLine(4, List.of(false, true, false));

        assertAll(
                () -> assertThat(line1.validate()).isTrue(),
                () -> assertThat(line2.validate()).isFalse(),
                () -> assertThat(line3.validate()).isFalse(),
                () -> assertThat(line4.validate()).isFalse()
        );
    }

    @Test
    @DisplayName("사람수가 1 미만이면 예외 발생")
    void fail_to_init_line_by_invalid_count_of_person() {
        assertThatExceptionOfType(InvalidCountOfPersonException.class)
                .isThrownBy(() -> new ManualLine(0, new ArrayList<>()));
    }

}
