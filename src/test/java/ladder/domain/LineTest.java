package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    public static Line LINE_1 = new Line(Arrays.asList(true, false, true));
    public static Line LINE_2 = new Line(Arrays.asList(false, true, false));

    @Test
    @DisplayName("라인 초기화 테스트")
    public void initLineTest() {
        Line newLine = new Line(Arrays.asList(true, false, true));

        assertThat(newLine.iterator().next()).isTrue();
    }

    @Test
    @DisplayName("라인 방향 테스트")
    public void getDirectionTest() {
        assertThat(LINE_1.getDirection(0).moveLeft()).isFalse();
        assertThat(LINE_1.getDirection(0).moveRight()).isTrue();

        assertThat(LINE_1.getDirection(1).moveLeft()).isTrue();
        assertThat(LINE_1.getDirection(1).moveRight()).isFalse();

        assertThat(LINE_1.getDirection(2).moveLeft()).isFalse();
        assertThat(LINE_1.getDirection(2).moveRight()).isTrue();

        assertThat(LINE_1.getDirection(3).moveLeft()).isTrue();
        assertThat(LINE_1.getDirection(3).moveRight()).isFalse();
    }
}
