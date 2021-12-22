package ladder.domain.ladder;

import ladder.domain.user.LadderPlayers;
import ladder.generator.DefaultLadderGenerator;
import ladder.generator.Generator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    private LadderHeight height;
    private Generator generator;
    private Ladder ladder;

    @BeforeEach
    void init() {
        LadderPlayers players = new LadderPlayers(Arrays.asList("pobi", "honux", "crong", "jk"));
        height = new LadderHeight(3);
        generator = new DefaultLadderGenerator(() -> true);
        ladder = generator.generate(players.size(), height);
    }

    @Test
    @DisplayName("Generator 로 ladder 생성 - height 만큼 라인 생성")
    void generateLadder() {
        Ladder ladder = generator.generate(2, height);
        assertThat(ladder.getLines()).size().isEqualTo(height.getHeight());
    }

    @ParameterizedTest
    @DisplayName("Line 마다 move 후 마지막 위치값을 반환")
    @MethodSource("provideMoveValue")
    void move(int input, int expected) {
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
