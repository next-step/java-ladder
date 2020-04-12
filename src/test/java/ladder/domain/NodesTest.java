package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NodesTest {

    private Node node1;
    private Node node2;

    @BeforeEach
    void setUp() {
        node1 = new Node(0, new Way(false, true));
        node2 = new Node(1, new Way(true, false));
    }

    @DisplayName("지정한 노드를 이동 시키고 다음 index를 반환 한다.")
    @Test
    public void move_success() throws Exception {
        //given
        Nodes nodes = new Nodes(Arrays.asList(node1, node2));

        //when
        int index = nodes.move(0);

        //then
        assertThat(index).isEqualTo(1);
    }

    @DisplayName("주어진 노드를 추가하고 새로 생성해서 반환한다.")
    @Test
    public void addNode_success() throws Exception {
        //given
        Nodes nodes = new Nodes(Arrays.asList(node1));

        //when
        nodes = nodes.addNode(node2);

        //then
        assertThat(nodes.getNodes().size()).isEqualTo(2);
    }


    @DisplayName("리스트가 비어있는지 체크 한다.")
    @Test
    public void empty_success() throws Exception {
        //given
        Nodes nodesFull = new Nodes(Arrays.asList(node1, node2));
        Nodes nodesEmpty = new Nodes(Arrays.asList());

        //then
        assertFalse(nodesFull.isEmpty());
        assertTrue(nodesEmpty.isEmpty());
    }
}
