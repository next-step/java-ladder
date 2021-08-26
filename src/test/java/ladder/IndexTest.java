package ladder;

import ladder.domain.Index;
import ladder.domain.Line;
import ladder.domain.Point;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class IndexTest {
    Line line;

    @BeforeAll
    void setUp() {
        // |-----|     |-----|  을 생성한다
        List<Point> points = new ArrayList<>();
        points.add(Point.of(false, true));
        points.add(Point.of(true, false));
        points.add(Point.of(false, true));
        points.add(Point.of(true, false));
        line = Line.from(points);
    }

    @DisplayName("위치인덱스를 입력 받으면 Index객체를 생성한다")
    @Test
    void newIndexTest() {
        assertThat(Index.from(1)).isInstanceOf(Index.class);
    }

    @DisplayName("인덱스 값이 음수이면 예외를 발생시킨다")
    @Test
    void throwExceptionIfNegativeTest() {
        assertThatThrownBy(() -> Index.from(-1)).isInstanceOf(IndexOutOfBoundsException.class);
    }

    @DisplayName("주어진 라인에서 포인트 위치에서, 오른쪽 다리가 있다면 그  방향으로 이동한다")
    @Test
    void moveRightTest() {
        Index index = Index.from(0);
        index.moveOf(line);
        assertThat(index.val()).isEqualTo(1);
    }

    @DisplayName("주어진 라인에서 포인트 위치에서, 왼쪽 다리가 있다면 그  방향으로 이동한다")
    @Test
    void moveLeftTest() {
        Index index = Index.from(3);
        index.moveOf(line);
        assertThat(index.val()).isEqualTo(2);
    }
}