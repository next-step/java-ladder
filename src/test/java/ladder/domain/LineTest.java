package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    @DisplayName("좌표값들을 인자로 받는 정적 팩토리 메서드 테스트")
    @Test
    void from() {
        List<Boolean> points = new ArrayList<>(Arrays.asList(false, true));

        Line line = Line.from(points);
        assertThat(line).isNotNull();
    }

    @DisplayName("참가자수와 라인전략을 인자로 받는 정적 팩토리 메서드 테스트")
    @Test
    void of() {
        Line line = Line.of(4, new RandomLineStrategy());
        assertThat(line).isNotNull();
    }
}