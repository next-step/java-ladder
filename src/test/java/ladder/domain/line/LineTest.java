package ladder.domain.line;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    /**
     * 선 이동 테스트
     * |-----| 1 -> 0, 0 -> 1
     * @param countOfPoint 포인트 개수
     * @param drawPosition draw 시작 포인트
     * @param startPosition 시작 위치
     * @param moveToPosition 이동 위치
     */
    @ParameterizedTest
    @CsvSource(value = {
        "2,0,1,0", "2,0,0,1"
    })
    @DisplayName("선 이동")
    void testMove(int countOfPoint, int drawPosition, int startPosition, int moveToPosition) {
        // given
        Line line = new Line(countOfPoint);
        // when
        line.drawsFrom(drawPosition);
        // then
        assertThat(line.move(startPosition)).isEqualTo(moveToPosition);
    }
}
