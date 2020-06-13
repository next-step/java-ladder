package ladder.domain.ladder;

import ladder.domain.ladder.strategy.RandomStairGenerationStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class StairTest {

    @DisplayName("계단의 상태값이 null 이면 예외 반환")
    @Test
    void createFailureByStairStateIsNull() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Stair.of(null));
    }

    @DisplayName("첫 번째 기둥의 계단은 랜던 전략으로 생성")
    @Test
    void createOfFirstPillar() {
        assertThatCode(() -> Stair.createOfFirstPillar(new RandomStairGenerationStrategy()))
                .doesNotThrowAnyException();
    }

    @DisplayName("중간 기둥의 계단은 앞에 계단이 있으면 계단을 생성 X, 없으면 랜덤 전략으로 계단 생성 : T -> F, F -> T/F")
    @Test
    void createOfMiddlePillar() {
        Stair previousStair = Stair.of(
                StairState.ofFirstPillar(new RandomStairGenerationStrategy()));

        boolean existLineOfPreviousStair = previousStair.isRightLineExist();
        boolean existLine = previousStair.createOfNextPillar(new RandomStairGenerationStrategy())
                .isRightLineExist();

        assertThat(existLineOfPreviousStair && existLine).isFalse();
    }

    @DisplayName("마지막 기둥에는 계단을 둘 수 없음")
    @Test
    void createOfLastPillar() {
        assertThat(Stair.createOfFirstPillar(new RandomStairGenerationStrategy())
                .createOfLastPillar()
                .isRightLineExist())
                .isEqualTo(false);
    }

    @DisplayName("해당 기둥의 계단의 상태에 따라 다음 위치를 반환")
    @ParameterizedTest
    @MethodSource
    void move(final Stair stair, final Position position, final Position expected) {
        assertThat(stair.move(position)).isEqualTo(expected);
    }

    private static Stream<Arguments> move() {
        final Position basePosition = Position.of(5);

        return Stream.of(
                Arguments.of(Stair.of(StairState.ofFirstPillar(() -> false)), basePosition, basePosition),
                Arguments.of(Stair.of(StairState.ofFirstPillar(() -> true)), basePosition, basePosition.moveRight()),
                Arguments.of(Stair.of(StairState.ofFirstPillar(() -> true).ofNextPillar(() -> false)),
                        basePosition, basePosition.moveLeft())
        );
    }

    @DisplayName("논리적 동치성 비교")
    @Test
    void equals() {
        assertThat(Stair.of(StairState.EMPTY))
                .isEqualTo(Stair.of(StairState.EMPTY));
    }
}
