package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NodeTest {

    @DisplayName("오른쪽으로 이동 가능한 첫 노드 생성")
    @Test
    public void node_success_moveRight() throws Exception {
        //given
        Node node = new Node(WayTest.strategyTrue);

        //then
        assertTrue(node.isMovableRight());
        assertFalse(node.isMovableLeft());
    }

    @DisplayName("오른쪽으로 이동 불가능한 첫 노드 생성")
    @Test
    public void node_success_moveNone() throws Exception {
        //given
        Node node = new Node(WayTest.strategyFalse);

        //then
        assertFalse(node.isMovableRight());
        assertFalse(node.isMovableLeft());
    }

    @DisplayName("이동 하고 다음 노드의 index 반환")
    @Test
    public void move_success() throws Exception {
        //given
        Node left = new Node(WayTest.strategyTrue);
        left = left.createNextNode(WayTest.strategyFalse);
        Node right = new Node(WayTest.strategyTrue);
        Node none = new Node(WayTest.strategyFalse);

        //then
        assertThat(left.move()).isEqualTo(0);
        assertThat(right.move()).isEqualTo(1);
        assertThat(none.move()).isEqualTo(0);
    }

    @DisplayName("현재 노드가 오른쪽으로 이동 가능 할때, 랜덥 값 상관 없이 다음 노드는 왼쪽으로 이동")
    @Test
    public void createNextNode_success_left() throws Exception {
        //given
        Node node = new Node(WayTest.strategyTrue);

        //when
        Node strategyTrue = node.createNextNode(WayTest.strategyTrue);
        Node strategyFalse = node.createNextNode(WayTest.strategyFalse);

        //then
        assertTrue(strategyTrue.isMovableLeft());
        assertTrue(strategyFalse.isMovableLeft());
    }

    @DisplayName("현재 노드가 왼쪽으로 이동 가능 할때 다음 노드의 방향을 랜덤으로 정해주고 생성")
    @Test
    public void createNextNode_success_right() throws Exception {
        //given
        Node node = new Node(WayTest.strategyTrue);
        node = node.createNextNode(WayTest.strategyFalse);

        //when
        Node noneNode = node.createNextNode(WayTest.strategyFalse);
        Node rightNode = node.createNextNode(WayTest.strategyTrue);

        assertFalse(noneNode.isMovableLeft());
        assertFalse(noneNode.isMovableRight());
        assertFalse(rightNode.isMovableLeft());
        assertTrue(rightNode.isMovableRight());
    }

    @DisplayName("마지막 노드를 만들어 준다")
    @Test
    public void createLast_success() throws Exception {
        //given
        Node nodeRight = new Node(WayTest.strategyTrue);
        Node nodeNone = new Node(WayTest.strategyFalse);

        Node lastLeft = nodeRight.createLast();
        Node lastNone = nodeNone.createLast();

        //then
        assertTrue(lastLeft.isMovableLeft());
        assertFalse(lastLeft.isMovableRight());

        assertFalse(lastNone.isMovableLeft());
        assertFalse(lastNone.isMovableRight());
    }
}
