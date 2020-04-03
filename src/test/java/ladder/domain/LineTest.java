package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

class LineTest {

    @DisplayName("생성자 테스트")
    @Test
    public void constructor_success() throws Exception {
        //given
        ArrayList<Node> nodes = new ArrayList<>(
                Arrays.asList(new Node(0, Way.right()),
                        new Node(1, Way.right())));
        Line line = new Line(nodes);

    }
}
