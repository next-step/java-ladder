package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LinesTest {

    private Lines lines = initialize();

    @DisplayName("라인 리스트가 존재하지 않으면 생성할 수 없다.")
    @Test
    void canNotCreateLinesIfLinesIsNullOrSize0() {
        assertThatThrownBy(() -> Lines.newInstance(null))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> Lines.newInstance(new ArrayList<>()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("라인 리스트가 유효하지 않은 라인이 있을 경우 생성할 수 없다.")
    @Test
    void canNotCreateLinesIfLinesContainsNull() {
        assertThatThrownBy(() -> {
            List<Point> points = Arrays.asList(Point.newInstance(true));
            List<Line> lines = new ArrayList<>(Arrays.asList(Line.newInstance(points)));
            lines.add(null);

            Lines.newInstance(lines);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("라인 목록을 생성할 수 있다.")
    @Test
    void canCreateLines() {
        assertThat(this.lines).isInstanceOf(Lines.class);
    }

    @DisplayName("라인 리스트를 얻을 수 있다.")
    @Test
    void canToList() {
        assertThat(this.lines.toList()).isInstanceOf(List.class);
    }

    @DisplayName("전체를 이동할 수 있다.")
    @Test
    void canMoveAll() {
        assertThat(this.lines.moveAll(Position.newInstance(0))).isEqualTo(Position.newInstance(2));
    }

    Lines initialize() {
        Line line1 = Line.newInstance(Arrays.asList(
                Point.newInstance(true),
                Point.newInstance(false)
        ));

        Line line2 = Line.newInstance(Arrays.asList(
                Point.newInstance(false),
                Point.newInstance(true)
        ));

        return Lines.newInstance(Arrays.asList(line1, line2));
    }
}
