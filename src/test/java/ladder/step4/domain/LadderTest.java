package ladder.step4.domain;

import ladder.step4.domain.strategy.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderTest {

    @DisplayName("사다리의 높이를 정상적으로 주입 받았는지 확인하는 테스트")
    @ParameterizedTest
    @MethodSource("provideLadderAndHeight")
    void 사다리_높이_확인_테스트(Ladder ladder, long expected) {
        assertEquals(expected, ladder.stream().count());
    }

    private static Stream<Arguments> provideLadderAndHeight() {
        Participants participants = Participants.of("a,b,c,d,e");
        DirectionStrategy strategy = RightDirectionStrategy.getInstance();
        return Stream.of(
            Arguments.of(Ladder.of(participants, LadderHeight.valueOf(5), strategy), 5),
            Arguments.of(Ladder.of(participants, LadderHeight.valueOf(4), strategy), 4),
            Arguments.of(Ladder.of(participants, LadderHeight.valueOf(3), strategy), 3),
            Arguments.of(Ladder.of(participants, LadderHeight.valueOf(2), strategy), 2),
            Arguments.of(Ladder.of(participants, LadderHeight.valueOf(1), strategy), 1)
        );
    }

    @DisplayName("사다리가 규칙에 맞게 잘 정상적으로 잘 생성 되는지 테스트")
    @ParameterizedTest
    @MethodSource("provideLadder")
    void 사다리_생성_테스트(Ladder ladder, List<List<Direction>> shape) {
        assertThat(ladder.stream()
                         .map(ladderLine -> ladderLine.stream()
                                                      .map(LadderPoint::getDirection)
                                                      .collect(toList())
                         ).collect(toList()))
            .isEqualTo(shape);
    }

    private static Stream<Arguments> provideLadder() {
        Participants participants = Participants.of("aa,bb,cc,dd");
        LadderHeight ladderHeight = LadderHeight.valueOf(3);
        return Stream.of(
            Arguments.of(
                Ladder.of(participants, ladderHeight, ToggleDirectionStrategy.getInstance()),
                Arrays.asList(
                    Arrays.asList(Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT),
                    Arrays.asList(Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT),
                    Arrays.asList(Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT)
                )
            ),
            Arguments.of(
                Ladder.of(participants, ladderHeight, RightDirectionStrategy.getInstance()),
                Arrays.asList(
                    Arrays.asList(Direction.RIGHT, Direction.RIGHT, Direction.RIGHT, Direction.RIGHT),
                    Arrays.asList(Direction.RIGHT, Direction.RIGHT, Direction.RIGHT, Direction.RIGHT),
                    Arrays.asList(Direction.RIGHT, Direction.RIGHT, Direction.RIGHT, Direction.RIGHT)
                )
            ),
            Arguments.of(
                Ladder.of(participants, ladderHeight, LeftDirectionStrategy.getInstance()),
                Arrays.asList(
                    Arrays.asList(Direction.LEFT, Direction.LEFT, Direction.LEFT, Direction.LEFT),
                    Arrays.asList(Direction.LEFT, Direction.LEFT, Direction.LEFT, Direction.LEFT),
                    Arrays.asList(Direction.LEFT, Direction.LEFT, Direction.LEFT, Direction.LEFT)
                )
            ),
            Arguments.of(
                Ladder.of(participants, ladderHeight, EmptyDirectionStrategy.getInstance()),
                Arrays.asList(
                    Arrays.asList(Direction.EMPTY, Direction.EMPTY, Direction.EMPTY, Direction.EMPTY),
                    Arrays.asList(Direction.EMPTY, Direction.EMPTY, Direction.EMPTY, Direction.EMPTY),
                    Arrays.asList(Direction.EMPTY, Direction.EMPTY, Direction.EMPTY, Direction.EMPTY)
                )
            )
        );
    }
}
