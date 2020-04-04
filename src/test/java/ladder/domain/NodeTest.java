package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NodeTest {

    @DisplayName("생성자 테스트")
    @Test
    public void constructor_success() throws Exception {
        new Node(1, new Way(false, false));
    }

    @DisplayName("이동 방향으로 움직일수 있는지 체크")
    @Test
    public void left_right() throws Exception {
        //given
        Node left = new Node(0, new Way(true, false));
        Node right = new Node(0, new Way(false, true));
        Node none = new Node(0, new Way(false, false));

        //then
        assertTrue(left.isMovableLeft());
        assertFalse(left.isMovableRight());
        assertTrue(right.isMovableRight());
        assertFalse(right.isMovableLeft());
        assertFalse(none.isMovableLeft());
        assertFalse(none.isMovableRight());
    }

    @DisplayName("이동 하고 다음 노드의 index 반환")
    @Test
    public void move() throws Exception {
        //given
        Node left = new Node(1, new Way(true, false));
        Node right = new Node(1, new Way(false, true));
        Node none = new Node(1, new Way(false, false));

        //then
        assertThat(left.move()).isEqualTo(0);
        assertThat(right.move()).isEqualTo(2);
        assertThat(none.move()).isEqualTo(1);
    }

    @DisplayName("현재 노드가 왼쪽으로 이동 가능 할때 다음 노드의 방향을 정해주고 생성")
    @Test
    public void createNextNode_success_left() throws Exception {
        //given
        Node current = new Node(0, new Way(true, false));

        //when
        Node moveRightNextNode = current.createNextNode(true);
        Node moveNoneNextNode = current.createNextNode(false);

        //then
        assertThat(moveRightNextNode.getIndex()).isEqualTo(1);
        assertThat(moveNoneNextNode.getIndex()).isEqualTo(1);

        assertFalse(moveRightNextNode.isMovableLeft());
        assertTrue(moveRightNextNode.isMovableRight());

        assertFalse(moveNoneNextNode.isMovableLeft());
        assertFalse(moveNoneNextNode.isMovableRight());
    }

    @DisplayName("현재 노드가 오른쪽으로 이동 가능 할때 다음 노드의 방향을 정해주고 생성")
    @Test
    public void createNextNode_success_right() throws Exception {
        //given
        Node current = new Node(0, new Way(false, true));

        //when
        Node moveRightNextNode = current.createNextNode(true);
        Node moveNoneNextNode = current.createNextNode(false);

        //then
        assertThat(moveRightNextNode.getIndex()).isEqualTo(1);
        assertThat(moveNoneNextNode.getIndex()).isEqualTo(1);

        assertTrue(moveRightNextNode.isMovableLeft());
        assertFalse(moveRightNextNode.isMovableRight());

        assertTrue(moveNoneNextNode.isMovableLeft());
        assertFalse(moveNoneNextNode.isMovableRight());
    }

    @DisplayName("첫 노드를 만들어 준다")
    @Test
    public void createFirst_success() throws Exception {
        //given
        Node firstRight = Node.createFirst(true);
        Node firstNone = Node.createFirst(false);

        //then
        assertFalse(firstRight.isMovableLeft());
        assertTrue(firstRight.isMovableRight());

        assertFalse(firstNone.isMovableLeft());
        assertFalse(firstNone.isMovableRight());
    }

    @DisplayName("마짐가 노드를 만들어 준다")
    @Test
    public void createLast_success() throws Exception {
        //given
        Node nodeRight = new Node(0, new Way(false, true));
        Node nodeNone = new Node(0, new Way(false, false));

        Node lastLeft = nodeRight.createLast();
        Node lastNone = nodeNone.createLast();

        //then
        assertTrue(lastLeft.isMovableLeft());
        assertFalse(lastLeft.isMovableRight());

        assertFalse(lastNone.isMovableLeft());
        assertFalse(lastNone.isMovableRight());
    }
}
