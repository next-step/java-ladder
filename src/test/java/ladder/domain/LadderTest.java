package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @DisplayName("Line 객체만을 인자로 받는 정적 팩토리 메서드 테스트")
    @Test
    void from() {
        List<Boolean> points = new ArrayList<>(Arrays.asList(false, true));
        List<Line> lines = new ArrayList<>(List.of(Line.from(points)));

        Ladder ladder = Ladder.from(lines);
        assertThat(ladder).isNotNull();
    }

    @DisplayName("사다리높이, 참가자수, 라인전략을 인자로 받는 정적 팩토리 메서드 테스트")
    @Test
    void of() {
        Ladder ladder = Ladder.of(5, 4, new RandomLineStrategy());
        assertThat(ladder).isNotNull();
    }
}