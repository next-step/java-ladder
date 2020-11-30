package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LineTest {

    @Test
    @DisplayName("오른쪽으로 이동 가능한지 확인")
    void line_hasRightMoved_isTrueOrFalse() {
        List<Boolean> lineResult = Arrays.asList(true, false, true, false, false);
        Line actual = Line.of(lineResult);

        assertAll(
                () -> assertThat(actual.hasRightMoved(0)).isTrue(),
                () -> assertThat(actual.hasRightMoved(1)).isFalse(),
                () -> assertThat(actual.hasRightMoved(2)).isTrue(),
                () -> assertThat(actual.hasRightMoved(3)).isFalse(),
                () -> assertThat(actual.hasRightMoved(4)).isFalse()
        );
    }

    @Test
    @DisplayName("라인 생성시 null 값 또는 size 가 0인 값으로 객체 생성시 exception 발생")
    void line_points_ThrowNullPointException() {
        assertThatThrownBy(() -> {
            Line.of(new ArrayList<>());
            Line.of(null);
        }).isInstanceOf(NullPointerException.class);
    }
}
