package nextstep.ladder.ladder;

import nextstep.ladder.strategy.RandomLadderStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LineTest {

    @DisplayName("카운트 수만큼 좌표를 추가한다.")
    @Test
    void line_size() {
        assertThat(Line.of(5, new RandomLadderStrategy()).getPoints()).hasSize(5);
    }

    @DisplayName("이전 좌표에 선이 있을 경우 현재 좌표에 선을 추가하지 않는다")
    @Test
    void line_create_line_or_not() {
        Line line = Line.of(2, () -> true);
        List<Boolean> points = line.getPoints();

        assertThat(points.get(1)).isFalse();
    }

    @DisplayName("인덱스에 해당하는 방향 정보를 리턴한다.")
    @Test
    void get_direction() {
        Line line = Line.of(3, () -> true);

        assertAll(
                () -> assertThat(line.findDirection(0)).isEqualTo(MoveType.RIGHT),
                () -> assertThat(line.findDirection(1)).isEqualTo(MoveType.LEFT),
                () -> assertThat(line.findDirection(2)).isEqualTo(MoveType.RIGHT)
        );
    }
}