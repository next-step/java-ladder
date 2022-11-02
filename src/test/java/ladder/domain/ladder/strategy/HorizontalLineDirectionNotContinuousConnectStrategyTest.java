package ladder.domain.ladder.strategy;

import ladder.domain.ladder.HorizontalLineDirection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class HorizontalLineDirectionNotContinuousConnectStrategyTest {

    private LadderConnectStrategy ladderConnectStrategy;

    @BeforeEach
    void setUp() {
        this.ladderConnectStrategy = new LadderDiscontinuousConnectStrategy();
    }

    private static Stream<Arguments> providesForGetConnectableLadder() {
        return Stream.of(
                Arguments.of(HorizontalLineDirection.LEFT,
                        List.of(HorizontalLineDirection.RIGHT, HorizontalLineDirection.NONE)),
                Arguments.of(HorizontalLineDirection.RIGHT, List.of(HorizontalLineDirection.LEFT)),
                Arguments.of(HorizontalLineDirection.NONE,
                        List.of(HorizontalLineDirection.RIGHT, HorizontalLineDirection.NONE))
        );
    }

    @ParameterizedTest(name = "사다리를 넣으면 연결 가능한 사다리 리스트를 반환한다.")
    @MethodSource(value = "providesForGetConnectableLadder")
    void connectable_ladder(HorizontalLineDirection beforeHorizontalLineDirection,
                            List<HorizontalLineDirection> connectableHorizontalLineDirectionList) {
        assertThat(ladderConnectStrategy.connectableLadders(beforeHorizontalLineDirection))
                .isEqualTo(connectableHorizontalLineDirectionList);
    }

    private static Stream<Arguments> providesForLastLadder() {
        return Stream.of(
                Arguments.of(HorizontalLineDirection.LEFT, HorizontalLineDirection.NONE),
                Arguments.of(HorizontalLineDirection.RIGHT, HorizontalLineDirection.LEFT),
                Arguments.of(HorizontalLineDirection.NONE, HorizontalLineDirection.NONE)
        );
    }

    @ParameterizedTest(name = "마지막에 올 수 있는 사다리를 반환한다.")
    @MethodSource("providesForLastLadder")
    void last_ladder(HorizontalLineDirection beforeHorizontalLineDirection,
                     HorizontalLineDirection lastHorizontalLineDirection) {
        assertThat(ladderConnectStrategy.lastLadder(beforeHorizontalLineDirection))
                .isSameAs(lastHorizontalLineDirection);
    }
}
