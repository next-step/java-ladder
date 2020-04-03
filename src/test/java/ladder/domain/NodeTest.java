package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NodeTest {

    @DisplayName("생성자 테스트")
    @Test
    public void constructor_success() throws Exception {
        new Node(1, Way.left());
    }
}
