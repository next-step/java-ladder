package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Collectors;
import ladder.strategy.LinkStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class LineTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 값을 할당하는 경우 Line 객체를 생성하는데 실패한다.")
    void create_with_empty_value(final List<Point> value) {
        assertThatThrownBy(() -> new Line(value)).
            isInstanceOf(IllegalArgumentException.class).
            hasMessage("입력 값이 누락되었습니다.");
    }

    @Test
    @DisplayName("link 메소드는 Line 객체가 가지고 있는 Point 객체들을 연결한다.")
    void link() {
        List<Point> points = List.of(
            new Point(0, 0),
            new Point(0, 1),
            new Point(0, 2),
            new Point(0, 3),
            new Point(0, 4)
        );
        Line line = new Line(points);
        line.link(new LinkStrategy() {
            @Override
            public List<Integer> link(int column) {
                return List.of(0, 2);
            }
        });

        assertThat(line.getPoints().stream()
            .filter(Point::isLinked)
            .collect(Collectors.toList())).containsOnly(new Point(0, 0), new Point(0, 2));
    }
}