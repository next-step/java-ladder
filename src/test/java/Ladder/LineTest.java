package Ladder;

import Ladder.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {

    @DisplayName("true가 중복으로 나오면 에러가 발생한다.")
    @Test
    void ErrorOnLineValidation() {
        List<Boolean> points = new ArrayList<>();
        points.add(false);
        points.add(true);
        points.add(true);

        assertThatThrownBy(() -> Line.of(points))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
