package ladder.domain.ladder;

import ladder.domain.participant.People;
import ladder.exception.PointListNullPointerException;
import ladder.strategy.LineGenerateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {

    @DisplayName("Line 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        List<Point> points = new ArrayList<>();

        // when
        Line line = Line.of(points);

        // then
        assertThat(line).isNotNull();
    }

    @DisplayName("Line 인스턴스에 null 주입시 예외처리 여부 테스트")
    @Test
    void 검증_NULL() {
        // given
        List<Point> points = null;

        // when and then
        assertThatThrownBy(() -> Line.of(points))
                .isInstanceOf(PointListNullPointerException.class)
                .hasMessage("List<Point>가 null 입니다.");
    }

    @DisplayName("Line 인스턴스가 전략에 맞게끔 Line 인스턴스를 만드는지 테스트")
    @Test
    void 검증_반환값() {
        // given
        Line expected = Line.of(Arrays.asList(Point.of(false), Point.of(true), Point.of(false)));
        People people = People.of("a, b, c".split(","));
        LineGenerateStrategy strategy = () -> true;

        // when
        Line actual = Line.of(people, strategy);

        // then
        assertThat(actual).isEqualTo(expected);
    }


}