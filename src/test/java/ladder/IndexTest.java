package ladder;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import ladder.domain.Index;
import ladder.domain.LadderLine;
import ladder.domain.Point;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class IndexTest {
    LadderLine ladderLine;

    @BeforeAll
    void setUp() {
        // |-----|     |-----|  을 생성한다
        List<Point> points = new ArrayList<>();
        points.add(Point.first(true));
        points.add(points.get(0).next(false));
        points.add(points.get(1).next(true));
        points.add(points.get(2).last());
        ladderLine = LadderLine.from(points);
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
        index.moveOf(ladderLine);
        assertThat(index.val()).isEqualTo(1);
    }

    @DisplayName("주어진 라인에서 포인트 위치에서, 왼쪽 다리가 있다면 그  방향으로 이동한다")
    @Test
    void moveLeftTest() {
        Index index = Index.from(3);
        index.moveOf(ladderLine);
        assertThat(index.val()).isEqualTo(2);
    }
}
