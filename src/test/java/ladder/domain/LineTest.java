package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    void 길이() {
        assertThat(Line.of(4).length()).isEqualTo(3);
    }

    @Test
    void 라인_랜덤생성() {
        assertThat(Line.of(4).points()).hasSize(3);
    }

    @Test
    void 라인_비정상_생성() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Line.of(List.of(true, true, false)))
            .withMessageMatching("겹치는 가로라인이 존재합니다.");
    }

    @Test
    void 라인_널_빈값() {
        assertAll(
            () -> assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Line.of(null))
                .withMessageMatching("라인은 빈 값일 수 없습니다."),
            () -> assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Line.of(List.of()))
                .withMessageMatching("라인은 빈 값일 수 없습니다.")
        );
    }
    @Test
    void 라인_정상_생성() {
        assertThat(Line.of(List.of(false, false, true))).isEqualTo(Line.of(List.of(false, false, true)));
    }

}
