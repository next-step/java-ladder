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
class LadderLineTest {
    final List<Point> points = new ArrayList<>();

    @BeforeAll
    void setUp() {
        points.add(Point.first(true));
        points.add(points.get(0).last());
    }

    @DisplayName("Point객체 리스트가 주어진다면 해당 Point 개수 만큼 Line객체를 생성한다")
    @Test
    void newLineTest1() {
        assertThat(LadderLine.from(points)).isInstanceOf(LadderLine.class);
        assertThat(LadderLine.from(points).toList().size()).isEqualTo(points.size());
    }

    @DisplayName("사다리 게임에 참여하는 입력값이 주어진다면 해당 인원 수 만큼 Line객체를 생성한다")
    @Test
    void newLineTest2() {
        int countOfPerson = 4;
        LadderLine ladderLine = LadderLine.init(countOfPerson);
        assertThat(ladderLine).isInstanceOf(LadderLine.class);
        assertThat(ladderLine.toList().size()).isEqualTo(countOfPerson);
    }

    @DisplayName("라인의 위치(인덱스)기준 왼쪽에 다리가 존재한다면, existLeftOf은 참을 반환한다")
    @Test
    void existLeftOfTest() {
        assertThat(LadderLine.from(points).existLeftOf(Index.from(0))).isFalse();
        assertThat(LadderLine.from(points).existLeftOf(Index.from(1))).isTrue();
    }

    @DisplayName("라인의 위치(인덱스)기준 오른쪽에 다리가 존재한다면, existRightOf은 참을 반환한다")
    @Test
    void existRightOfTest() {
        assertThat(LadderLine.from(points).existRightOf(Index.from(0))).isTrue();
        assertThat(LadderLine.from(points).existRightOf(Index.from(1))).isFalse();
    }
}
