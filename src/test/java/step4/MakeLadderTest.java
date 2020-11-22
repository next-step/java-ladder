package step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import step4.domain.ladder.*;
import step4.domain.ladder.dto.LadderBuildDTO;
import step4.strategy.MakeLineStrategy;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class MakeLadderTest {
    private MakeLineStrategy allTrueStrategy;
    private MakeLineStrategy allFalseStrategy;

    @BeforeEach
    void setup() {
        allTrueStrategy = (count)-> IntStream.range(0, count - 1)
                .mapToObj((index) -> true)
                .collect(Collectors.toList());

        allFalseStrategy = (count)-> IntStream.range(0, count - 1)
                .mapToObj((index) -> false)
                .collect(Collectors.toList());
    }


    @DisplayName("라인 생성 전략")
    @Test
    void executeLineStrategy() {
        Line allMarkedLine = Line.of(4, allTrueStrategy);
        Line allUnMarkedLine = Line.of(4, allFalseStrategy);

        assertThat(allMarkedLine.isExistsPoint(new Point(0, 0))).isTrue();
        assertThat(allMarkedLine.isExistsPoint(new Point(1, 0))).isTrue();
        assertThat(allMarkedLine.isExistsPoint(new Point(2, 0))).isTrue();

        assertThat(allUnMarkedLine.isExistsPoint(new Point(0, 0))).isFalse();
        assertThat(allUnMarkedLine.isExistsPoint(new Point(1, 1))).isFalse();
        assertThat(allUnMarkedLine.isExistsPoint(new Point(2, 2))).isFalse();

    }

    @DisplayName("사다리 생성 테스트")
    @ParameterizedTest
    @MethodSource("provideLadderPlayersAndLadderHeight")
    void makeLadder(LadderPlayers players, int height) {
        Ladder ladder = LadderGame.makeLadder(new LadderBuildDTO(players, height), allTrueStrategy);
        System.out.println(players.toString());

        assertThat(ladder.isExistsPoint(new Point(0,0))).isTrue();
        assertThat(ladder.isExistsPoint(new Point(0,1))).isTrue();
        assertThat(ladder.isExistsPoint(new Point(0,2))).isTrue();
    }

    private static Stream<Arguments> provideLadderPlayersAndLadderHeight() {
        return Stream.of(
                Arguments.of(LadderGame.join("pobi,crong,haha,bibi"), 3)
        );
    }

    @DisplayName("사다리 생성 높이 음수 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,haha,bibi"})
    void makeLadderFromMinusHeight(String input) {
        LadderPlayers players = LadderGame.join(input);
        int ladderHeight = -1;
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderGame.makeLadder(new LadderBuildDTO(players, ladderHeight), allTrueStrategy))
                .withMessage(Ladder.ERROR_INVALID_LADDER_HEIGHT);
    }
}
