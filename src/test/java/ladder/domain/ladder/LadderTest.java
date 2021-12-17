package ladder.domain.ladder;

import ladder.domain.user.LadderPlayers;
import ladder.strategy.RandomLine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @ParameterizedTest
    @DisplayName("사다리 객체 생성 - 입력된 height 만큼 라인 객체를 갖고있음")
    @CsvSource(value = {"3,4,5"})
    void create(int height) {
        Ladder ladder = Ladder.createLadder(new RandomLine(), LadderComponent.of(2, height));
        assertThat(ladder.getLines()).size().isEqualTo(height);
    }

    @ParameterizedTest
    @DisplayName("Line 마다 move 후 마지막 위치값을 반환")
    @MethodSource("provideMoveValue")
    void move(int input, int expected) {
        Ladder ladder = Ladder.createLadder(() -> true, LadderComponent.of(4, 3));
        assertThat(ladder.move(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideMoveValue() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(1, 0),
                Arguments.of(2, 3),
                Arguments.of(3, 2)
        );
    }

}
