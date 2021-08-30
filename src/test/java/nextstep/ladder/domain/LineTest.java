package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LineTest {

    @DisplayName("라인에 올바른(true 이후엔 반드시 false) boolean 리스트가 오면 생성된다.")
    @Test
    void create() {
        Line line = new Line(Arrays.asList(false, true, false));
        assertThat(line).isEqualTo(new Line(Arrays.asList(false, true, false)));
    }

    @DisplayName("라인에 올바르지 않은 boolean 리스트가 오면 생성 실패")
    @Test
    void create_fail() {
        assertThrows(IllegalArgumentException.class,
                () -> new Line(Arrays.asList(true, true, false)));
    }


    @Test
    void createRandom() {
        Line line = new Line(3); // 사다리 타기 3명
        line.valueOfPoints().stream()
                .forEach(System.out::print);
    }
}