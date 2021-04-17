package nextstep.ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

public class LadderLineTest {
    private LadderLine ladderLine;
    @BeforeEach
    void setUp() {
        int sizeOfPerson = 5;
        ladderLine = LadderLine.init(sizeOfPerson, () -> TRUE);
    }

    @Test
    @DisplayName(value = "사다리 라인 초기화")
    public void init() {
        List<Point> points = new ArrayList<Point>(){
            {
                add(Point.first(TRUE));
                add(Point.first(TRUE).next(FALSE));
                add(Point.first(TRUE).next(FALSE).next(TRUE));
                add(Point.first(TRUE).next(FALSE).next(TRUE).next(FALSE));
                add(Point.first(TRUE).next(FALSE).next(TRUE).next(FALSE).next(FALSE));
            }
        };

        assertThat(ladderLine.points())
                .isEqualTo(points);
    }

    @Test
    @DisplayName(value = "사다리 특정 좌표 이동")
    public void move() {
        Point point = Point.first(TRUE).next(FALSE).next(TRUE);

        assertThat(ladderLine.move(2))
                .isEqualTo(point.move());
    }
}
