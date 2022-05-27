package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {

    @Test
    @DisplayName("라인 생성 테스트")
    void line_creation(){
        Line line = Line.of(4, ()->true);
        assertThat(line.getPoints()).containsExactly(
                false, true, false, true, false, false
        );
    }

    @Test
    @DisplayName("0개 미만의 포인트 개수로 Line 생성시 예외를 던진다.")
    void line_creation_exception(){
        assertThatThrownBy(()->{
            Line.of(-1, ()->true);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("null값으로 라인 생성시 예외를 던진다.")
    void line_creation_exception2(){
        assertThatThrownBy(()->{
            new Line(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("라인에서 움직인 후 위치를 반환한다.")
    @CsvSource(value = {
            "0, 1",
            "1, 0",
            "2, 3",
            "3, 2",
            "4, 4"
    })
    void 움직인후_위치(int startIndex, int endIndex){
        Line line = new Line(List.of(false, true, false, true, false, false));
        assertThat(line.moveFrom(startIndex)).isEqualTo(endIndex);
    }
}