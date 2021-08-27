package ladder;

import ladder.domain.Index;
import ladder.domain.Line;
import ladder.domain.Point;
import ladder.exception.PersonCountException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LineTest {
    final List<Point> points = new ArrayList<>();

    @BeforeAll
    void setUp() {
        points.add(Point.of(false, true));
        points.add(Point.of(true, false));
    }

    @DisplayName("Point객체 리스트가 주어진다면 해당 Point 개수 만큼 Line객체를 생성한다")
    @Test
    void newLineTest1() {
        assertThat(Line.from(points)).isInstanceOf(Line.class);
        assertThat(Line.from(points).toList().size()).isEqualTo(points.size());
    }

    @DisplayName("사다리 게임에 참여하는 입력값이 주어진다면 해당 인원 수 만큼 Line객체를 생성한다")
    @Test
    void newLineTest2() {
        int countOfPerson = 4;
        Line line = Line.from(countOfPerson);
        assertThat(line).isInstanceOf(Line.class);
        assertThat(line.toList().size()).isEqualTo(countOfPerson);
    }

    @DisplayName("사다리 게임에 참여하는 인원수가 1명 이하이면 예외가 발생한다")
    @Test
    void exceptionTest() {
        assertThatThrownBy(() -> Line.from(1)).isInstanceOf(PersonCountException.class);
    }

    @DisplayName("라인의 위치(인덱스)기준 왼쪽에 다리가 존재한다면, existLeftOf은 참을 반환한다")
    @Test
    void existLeftOfTest() {
        assertThat(Line.from(points).existLeftOf(Index.from(0))).isFalse();
        assertThat(Line.from(points).existLeftOf(Index.from(1))).isTrue();
    }

    @DisplayName("라인의 위치(인덱스)기준 오른쪽에 다리가 존재한다면, existRightOf은 참을 반환한다")
    @Test
    void existRightOfTest() {
        assertThat(Line.from(points).existRightOf(Index.from(0))).isTrue();
        assertThat(Line.from(points).existRightOf(Index.from(1))).isFalse();
    }
}
