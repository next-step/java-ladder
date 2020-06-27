package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LadderTest {
    @ParameterizedTest(name = "사다리 높이 = {0}, 입력받은 이름 = {1}")
    @MethodSource("heightAndCountOfPlayers")
    @DisplayName("입력받은 이름과 사다리 높이로 Ladder 생성")
    void create_ladder(int height, int countOfPlayers) {
        Ladder ladder = Ladder.of(Height.of(height), countOfPlayers);
        assertThat(ladder.getLineSize()).isEqualTo(height);
    }

    static Stream<Arguments> heightAndCountOfPlayers() {
        return Stream.of(
                arguments(1, 2),
                arguments(2, 3),
                arguments(3, 3));
    }
}