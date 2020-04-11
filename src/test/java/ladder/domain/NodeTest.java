package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NodeTest {
    @DisplayName("생성")
    @ParameterizedTest
    @ValueSource(ints = {0, 3, 4, 10, 100})
    void create(int input) {
        Node node = Node.of("yohan", input);

        assertThat(node.getPosition()).isEqualTo(input);
    }

    @DisplayName("Node 의 startPosition 은 음수 일 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, -5, -10})
    void exceptByCreation(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Node.of("yohan", input);
        });
    }

    @DisplayName("Node 은 LinkDirection 에 따라 움직인다.")
    @Test
    void move() {
        Node node = Node.of("yohan", 0);
        Node node2 = Node.of("yohan", 1);

        node.move(s -> 1); // 전진
        node.move(s -> 0); // 그대로
        node2.move(s -> -1); // 후진

        assertThat(node).isEqualTo(Node.of("yohan", 1));
        assertThat(node2).isEqualTo(Node.of("yohan", 0));
    }
}
