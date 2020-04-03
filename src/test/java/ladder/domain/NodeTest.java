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
        new Node(1, Way.left());
    }

    @DisplayName("이동 방향으로 움직일수 있는지 체크")
    @Test
    public void left_right() throws Exception {
        //given
        Node left = new Node(0, Way.left());
        Node right = new Node(0, Way.right());
        Node none = new Node(0, Way.none());

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
        Node left = new Node(1, Way.left());
        Node right = new Node(1, Way.right());
        Node none = new Node(1, Way.none());

        //then
        assertThat(left.move()).isEqualTo(0);
        assertThat(right.move()).isEqualTo(2);
        assertThat(none.move()).isEqualTo(1);
    }
}
