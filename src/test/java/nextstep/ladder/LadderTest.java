package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Point;
import nextstep.ladder.domain.Row;
import nextstep.ladder.dto.PointDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderTest {
    Ladder ladder;

    @BeforeEach
    void setup() {
        List<Row> rows = new ArrayList<>();
        List<Point> points = new ArrayList<>();
        points.add(new Point(false, true));
        points.add(new Point(true, false));
        points.add(new Point(false, false));
        Row row = new Row(points);
        rows.add(row);
        List<Point> points2 = new ArrayList<>();
        points2.add(new Point(false, false));
        points2.add(new Point(false, true));
        points2.add(new Point(true, false));
        Row row2 = new Row(points2);
        rows.add(row2);
        ladder = new Ladder(rows);
    }

    @Test
    void 사다리_생성_테스트() {
        List<List<PointDto>> ladder = Ladder.of(3, 3, (left, x) -> new Point(false, false)).toLadderDto();
        for (List<PointDto> row : ladder) {
            row.stream().forEach(o -> {
                assertThat(o.isRight()).isFalse();
                assertThat(o.isLeft()).isFalse();
            });
        }
    }

    @Test
    void 결과_x좌표_구하기() {
        assertThat(ladder.getResultX(0)).isEqualTo(2);
        assertThat(ladder.getResultX(1)).isEqualTo(0);
        assertThat(ladder.getResultX(2)).isEqualTo(1);
    }
}
