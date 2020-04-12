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

    @DisplayName("팩토리 메서드 테스트")
    @Test
    public void of_success() throws Exception {
        //given
        Line line = Line.of(3);

        //when
        int size = line.getNodes().size();

        //then
        assertThat(size).isEqualTo(3);
    }
}
