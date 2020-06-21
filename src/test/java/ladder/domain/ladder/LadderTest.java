package ladder.domain.ladder;

import ladder.domain.play.Items;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LadderTest {
    private static final Items inputs = Items.of(Arrays.asList("pobi", "honux", "crong", "jk"));

    @ParameterizedTest(name = "사다리 높이 = {0}, 입력받은 이름 = {1}")
    @MethodSource("heightAndItems")
    @DisplayName("입력받은 이름과 사다리 높이로 Ladder 생성")
    void create_ladder(int height, Items inputs) {
        Ladder ladder = Ladder.of(height, inputs);
        assertThat(ladder.getFootStepSize()).isEqualTo(height);
    }

    static Stream<Arguments> heightAndItems() {
        return Stream.of(
                arguments(1, Items.of(Arrays.asList("pobi", "honux"))),
                arguments(2, Items.of(Arrays.asList("pobi", "honux", "crong"))),
                arguments(3, Items.of(Arrays.asList("pobi", "honux", "crong", "jk"))));
    }

    @ParameterizedTest(name = "사다리 높이 = {0}")
    @ValueSource(ints = 0)
    @DisplayName("사다리 높이는 1이상이 아닌 경우 생성할 수 없다")
    void does_not_create_ladder(int height) {
        assertThatThrownBy(() -> Ladder.of(height, inputs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 높이는 1이상의 값이어야 합니다.");
    }
}