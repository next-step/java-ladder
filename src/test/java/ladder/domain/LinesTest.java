package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LinesTest {
    Names names = Names.of("1,2,3");
    Lines lines;

    @BeforeEach
    void setUp() {
        lines = new Lines(names.size());
    }

    @Test
    @DisplayName("Lines 는 VerticalLines 을 인자로 받아 of 로 생성한다")
    void of() {
        assertThat(lines.size()).isEqualTo(names.size());
    }

    @Test
    @DisplayName("List<boolean> 을 받아 알맞은 값으로 초기화된 Lines 를 반환한다")
    void of2() {
        Line trueLine = Line.of(true);
        Line falseLine = Line.of(false);
        lines = Lines.of(() -> Arrays.asList(false, true, false, true));

        assertThat(lines.getLines()).containsExactly(falseLine, trueLine, falseLine, trueLine);
    }

    @Test
    @DisplayName("0번째 boolean 이 true 인 List<boolean> 을 받으면 에러 발생")
    void of3() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() ->
                Lines.of(() -> Arrays.asList(true, false))
        );
    }

    @Test
    @DisplayName("연속으로 true 값이 있는 List<boolean> 을 받으면 에러 발생")
    void of4() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() ->
                Lines.of(() -> Arrays.asList(false, true, true))
        );
    }

    @Test
    @DisplayName("Line 존재 여부에 따라 이동을 한다.")
    void move() {
        lines = Lines.of(() -> Arrays.asList(false, true, false, false));
        assertThat(lines.move(0)).isEqualTo(1);
        assertThat(lines.move(3)).isEqualTo(3);
    }
}
