package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    void 길이() {
        assertThat(Line.of(i -> List.of(false, false, false), 4).length()).isEqualTo(3);
    }

    @Test
    void 라인_랜덤생성() {
        assertThat(Line.of(i -> List.of(false, false, false),4).points()).hasSize(3);
    }

    @Test
    void 라인_겹침_입력() {
        assertThat(Line.of(i -> List.of(true, true, true, true, true), 4)).isEqualTo(Line.of(i -> List.of(true, false, true, false, true), 4));
    }

    @Test
    void 라인_널_빈값() {
        assertAll(
            () -> assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Line.of(i -> null, 1))
                .withMessageMatching("라인은 빈 값일 수 없습니다."),
            () -> assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Line.of(i -> List.of(), 1))
                .withMessageMatching("라인은 빈 값일 수 없습니다.")
        );
    }

    @Test
    void 라인_정상_생성() {
        assertThat(Line.of(i -> List.of(false, false, true), 4)).isEqualTo(Line.of(i -> List.of(false, false, true), 4));
    }

}
