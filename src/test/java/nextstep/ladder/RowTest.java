package nextstep.ladder;

import nextstep.ladder.domain.Point;
import nextstep.ladder.domain.Row;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RowTest {
    Row row;
    List<Point> points;

    @BeforeEach
    void setup() {
        points = new ArrayList<>();
        points.add(new Point(false, true));
        points.add(new Point(true, false));
        points.add(new Point(false, false));
        row = new Row(points);
    }

    @Test
    void Row_생성_테스트() {
        assertThat(Row.of((left, x) ->
                new Point(false, false), 3).getRow().size()).isEqualTo(3);
    }

    @Test
    void 왼쪽_확인_테스트() {
        assertThat(Row.existLeft(points, 1)).isTrue();
        assertThat(Row.existLeft(points, 2)).isFalse();
    }


}
