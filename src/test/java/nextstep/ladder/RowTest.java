package nextstep.ladder;

import nextstep.ladder.domain.Point;
import nextstep.ladder.domain.Row;
import nextstep.ladder.dto.PointDto;
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
        List<PointDto> pointDtos = Row.of((left, x) ->
                new Point(false, false), 3).toPointDtos();

        for (int i = 0; i < pointDtos.size(); i++) {
            assertThat(pointDtos.get(i).isLeft()).isFalse();
            assertThat(pointDtos.get(i).isRight()).isFalse();
        }
    }

    @Test
    void 왼쪽_확인_테스트() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(false, true));
        points.add(new Point(true, false));
        points.add(new Point(false, false));
        Row row = new Row(points);
        assertThat(Row.existLeft(points, 1)).isTrue();
        assertThat(Row.existLeft(points, 2)).isFalse();
    }


}
