package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @DisplayName("생성자 테스트")
    @Test
    public void constructor_success() throws Exception {
        //given
        ArrayList<Node> nodes = new ArrayList<>(
                Arrays.asList(
                        new Node(0, new Way(false, false)),
                        new Node(1, new Way(false, false))));
        Line line = new Line(nodes);
    }

    @DisplayName("참가자 수만큼의 Node를 가진 Line을 생성한다")
    @Test
    public void of_success() throws Exception {
        //given
        Line line = Line.of(3);

        //when
        int size = line.getNodes().size();

        //then
        assertThat(size).isEqualTo(3);
    }

    @DisplayName("한 라인의 노드를 이동 시키고 결과 노드의 index 값을 반환 한다")
    @Test
    public void move_success() throws Exception {
        //given
        Way right = new Way(false, true);
        Way left = new Way(true, false);
        Node node1 = new Node(0, right);
        Node node2 = new Node(1, left);
        Line line = new Line(Arrays.asList(node1, node2));

        //when
        int moveIndex = line.move(0);

        //then
        assertThat(moveIndex).isEqualTo(1);
    }
}
