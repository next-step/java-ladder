package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

class LineTest {

    private Line line;

    @BeforeEach
    void setUp() {
        line = Line.of(2, WayTest.strategyTrue);
    }

    @DisplayName("참가자 수만큼의 Node를 가진 Line을 생성한다")
    @Test
    public void of_success() throws Exception {
        //given
        Line line = Line.of(3, WayTest.strategyTrue);

        //when
        int size = line.getNodes().size();

        //then
        assertThat(size).isEqualTo(3);
    }

    @DisplayName("생성된 Line의 마지막 노드는 오른쪽 으로 진행 불가능 하다")
    @Test
    public void of_success_lastNode() throws Exception {
        //given
        Line line = Line.of(3, WayTest.strategyTrue);

        //then
        assertFalse(line.getNodes().get(line.getNodes().size() - 1).isMovableRight());
    }

    @DisplayName("생성된 Line의 첫 노드는 왼쪽 으로 진행 불가능 하다")
    @Test
    public void of_success_firstNode() throws Exception {
        //given
        Line line = Line.of(3, WayTest.strategyTrue);

        //then
        assertFalse(line.getNodes().get(0).isMovableLeft());
    }

    @DisplayName("한 라인의 노드를 이동 시키고 결과 노드의 index 값을 반환 한다")
    @Test
    public void move_success() throws Exception {
        //when
        int moveIndex = line.move(0);

        //then
        assertThat(moveIndex).isEqualTo(1);
    }
}
