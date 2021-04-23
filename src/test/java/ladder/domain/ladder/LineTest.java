package ladder.domain.ladder;

import ladder.domain.strategy.LineGenerateStrategy;
import ladder.exception.PointListNullPointerException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {

    @DisplayName("Line 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        int sizeOfPerson = 5;
        LineGenerateStrategy strategy = () -> true;

        // when
        Line line = Line.of(sizeOfPerson, strategy);

        // then
        assertThat(line).isNotNull();
    }

    @DisplayName("Line 인스턴스에 null 주입시 예외처리 여부 테스트")
    @Test
    void 검증_null() {
        // given
        List<Point> pointList = null;

        // when and then
        assertThatThrownBy(() -> Line.of(pointList))
                .isInstanceOf(PointListNullPointerException.class)
                .hasMessage("List<Point>가 null 입니다.");

    }

}