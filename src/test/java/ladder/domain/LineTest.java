package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LineTest {
    @DisplayName("좌표값들을 인자로 받아 Line 객체를 생성하는 테스트")
    @Test
    void from() {
        List<Boolean> points = new ArrayList<>(Arrays.asList(false, true));

        Line line = Line.from(points);
        assertThat(line).isNotNull();
    }

    @DisplayName("참가자수와 라인전략을 인자로 받아 Line 객체를 생성하는 테스트")
    @Test
    void of() {
        Line line = Line.of(4, new RandomLineStrategy());
        assertThat(line).isNotNull();
    }

    @DisplayName("생성하려는 Line 객체의 좌표값들이 존재하지 않는 경우 예외 발생 테스트")
    @Test
    void emptyException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Line.from(new ArrayList<>()))
                .withMessageContaining("존재하지 않습니다.")
        ;
    }

    @DisplayName("생성하려는 Line 객체의 좌표값들이 겹치는 경우 예외 발생 테스트")
    @Test
    void overlapException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Line.from(new ArrayList<>(List.of(false, true, true))))
                .withMessageContaining("겹치는 경우")
        ;
    }
}