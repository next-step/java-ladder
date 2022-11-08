package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LinesTest {

    @DisplayName("사다리 라인 목록 생성")
    @Test
    void create() {
        assertDoesNotThrow(() -> new Lines(
                Arrays.asList(
                        new Line(Arrays.asList(true, false, true, false)),
                        new Line(Arrays.asList(true, false, true, false))
                )
        ));
    }

    @DisplayName("사다리 라인 목록 생성 실패 - null")
    @Test
    void invalid_null() {
        assertThatThrownBy(() -> new Lines(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("최소 1개 이상의 사다리 라인이 필요합니다.");
    }

    @DisplayName("사다리 라인 목록 생성 실패 - emptyList")
    @Test
    void invalid_emptyList() {
        assertThatThrownBy(() -> new Lines(Collections.emptyList()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("최소 1개 이상의 사다리 라인이 필요합니다.");
    }

    @DisplayName("사다리 라인 목록 생성 실패 - diffLineSize")
    @Test
    void invalid_diffLineSize() {
        assertThatThrownBy(() -> new Lines(
                Arrays.asList(
                        new Line(Arrays.asList(true, false, true, false)),
                        new Line(Arrays.asList(true, false, true))
                )
        )).isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining("모든 사다리 라인의 사이즈는 동일해야 합니다.");
    }
}
