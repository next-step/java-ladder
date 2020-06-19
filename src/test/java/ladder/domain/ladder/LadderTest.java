package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LadderTest {
    private static final List<String> names = Arrays.asList("pobi", "honux", "crong", "jk");

    @ParameterizedTest(name = "사다리 높이 = {0}, 입력받은 이름 = {1}")
    @MethodSource("heightAndNames")
    @DisplayName("입력받은 이름과 사다리 높이로 Ladder 생성")
    void create_ladder(int height, List<String> names) {
        Ladder ladder = Ladder.of(height, names);
        assertThat(ladder.getFootStepSize()).isEqualTo(height);
        assertThat(ladder.getCountOfUsers()).isEqualTo(names.size());
    }

    static Stream<Arguments> heightAndNames() {
        return Stream.of(
                arguments(1, Arrays.asList("pobi", "honux")),
                arguments(2, Arrays.asList("pobi", "honux", "crong")),
                arguments(3, Arrays.asList("pobi", "honux", "crong", "jk")));
    }

    @ParameterizedTest(name = "사다리 높이 = {0}")
    @ValueSource(ints = 0)
    @DisplayName("사다리 높이는 1이상이 아닌 경우 생성할 수 없다")
    void does_not_create_ladder(int height) {
        assertThatThrownBy(() -> Ladder.of(height, names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 높이는 1이상의 값이어야 합니다.");
    }
}