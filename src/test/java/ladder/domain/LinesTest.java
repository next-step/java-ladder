package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LinesTest {

    @Test
    @DisplayName("라인 일급컬렉션 생성시 null 값 또는 size 가 0인 값으로 객체 생성시 IllegalArgumentException 발생")
    void line_points_ThrowIllegalArgumentException() {
        assertThatThrownBy(() -> {
            Lines.of(new ArrayList<>());
            Lines.of(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
