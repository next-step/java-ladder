package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {

    @Test
    @DisplayName("0 이하의 길이로 초기화 시 예외")
    void testCreateNegativeLength() {
        assertThatThrownBy(() -> new Line(0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Line(-10)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("라인 길이")
    void testLineLength() {
        final int length = 5;
        assertThat(new Line(length).countOfPoint()).isEqualTo(length);
    }

    @Test
    @DisplayName("기본적으로 끊어진 상태로 생성되는지")
    void testCreateLineSliced() {
        final int length = 5;
        Line line = new Line(length);
        for (int i = 0; i < length; i++) {
            assertThat(line.startsWith(i)).isFalse();
        }
    }

    @Test
    @DisplayName("선 연결")
    void testDrawLine() {
        // given
        Line line = new Line(5);
        final int drawPosition = 1;
        // when
        line.drawsFrom(drawPosition);
        // then
        assertThat(line.startsWith(drawPosition)).isTrue();
    }
}
