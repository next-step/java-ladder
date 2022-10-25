package ladder.domain.ladder.strategy;

import ladder.domain.ladder.Ladder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class LadderNotContinuousConnectStrategyTest {

    private LadderConnectStrategy ladderConnectStrategy;

    @BeforeEach
    void setUp() {
        this.ladderConnectStrategy = new LadderNotContinuousConnectStrategy();
    }

    private static Stream<Arguments> providesForGetConnectableLadder() {
        return Stream.of(
                Arguments.of(Ladder.LEFT, List.of(Ladder.RIGHT, Ladder.NONE)),
                Arguments.of(Ladder.RIGHT, List.of(Ladder.LEFT)),
                Arguments.of(Ladder.NONE, List.of(Ladder.RIGHT, Ladder.NONE))
        );
    }

    @ParameterizedTest(name = "사다리를 넣으면 연결 가능한 사다리 리스트를 반환한다.")
    @MethodSource(value = "providesForGetConnectableLadder")
    void connectable_ladder(Ladder beforeLadder, List<Ladder> connectableLadderList) {
        LadderConnectStrategy ladderConnectStrategy = new LadderNotContinuousConnectStrategy();

        assertThat(ladderConnectStrategy.connectableLadders(beforeLadder)).isEqualTo(connectableLadderList);
    }

    private static Stream<Arguments> providesForLastLadder() {
        return Stream.of(
                Arguments.of(Ladder.LEFT, Ladder.NONE),
                Arguments.of(Ladder.RIGHT, Ladder.LEFT),
                Arguments.of(Ladder.NONE, Ladder.NONE)
        );
    }

    @ParameterizedTest(name = "마지막에 올 수 있는 사다리를 반환한다.")
    @MethodSource("providesForLastLadder")
    void last_ladder(Ladder beforeLadder, Ladder lastLadder) {
        assertThat(ladderConnectStrategy.lastLadder(beforeLadder)).isSameAs(lastLadder);
    }
}
