package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    private List<Node> nodes;
    private Line line;

    @BeforeEach
    void setUp() {
        nodes = Arrays.asList(
                new Node(0, new Way(false, true)),
                new Node(1, new Way(true, false)));
        line = new Line(nodes);
    }


    @DisplayName("생성자 테스트")
    @Test
    public void constructor_success() throws Exception {
        //given
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
        //when
        int moveIndex = line.move(0);

        //then
        assertThat(moveIndex).isEqualTo(1);
    }

    @DisplayName("노드의 개수를 반환 한다.")
    @Test
    public void getNoteSize_success() throws Exception {
        //given
        int noteSize = line.getNoteSize();

        //then
        assertThat(noteSize).isEqualTo(2);
    }
}
