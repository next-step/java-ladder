package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class DirectionTest {

    @ParameterizedTest
    @CsvSource(value = {"true,false", "false,true", "false,false"})
    @DisplayName("Direction 은 좌우 방향 중 한쪽 방향을 가지거나 방향이 없다")
    void create(boolean isLeft, boolean isRight) {
        Direction direction = Direction.of(isLeft, isRight);
        assertThat(direction).isNotNull();
    }

    @Test
    @DisplayName("Direction 양쪽 방향 생성 시 예외 발생")
    void exceptByCreate() {
        assertThatIllegalArgumentException().isThrownBy(() -> Direction.of(true, true))
                .withMessage("Direction 은 양쪽 방향을 가질 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("첫번째 Direction 왼쪽 방향을 가질 수 없다.")
    void createFirstDirection(boolean isRight) {
        Direction firstDirection = Direction.first(isRight);

        assertThat(firstDirection.isLeft()).isFalse();
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("마지막 Direction 은 오른쪽 방향을 가질 수 없다.")
    void createLastDirection(boolean isRight) {
        Direction preLastDirection = Direction.of(false, isRight);
        Direction lastDirection = preLastDirection.last();

        assertThat(lastDirection.isRight()).isFalse();
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("n번째 Direction 의 오른쪽 방향 == n+1번째 Direction 의 왼쪽 방향")
    void createNextDirection(boolean isRight) {
        Direction direction = Direction.of(false, isRight);
        Direction nextDirection = direction.next(false);

        assertThat(nextDirection.isRight()).isFalse();
    }

    @ParameterizedTest
    @CsvSource(value = {"true,false", "false,true", "false,false"})
    @DisplayName("DirectionStrategy를 사용한 next, first Direction 생성")
    void createNextDirectionUsingStrategy(boolean firstDirectionRight, boolean nextDirectionRight) {
        Direction firstDirection = Direction.first(() -> firstDirectionRight);
        Direction nextDirection = firstDirection.next(() -> nextDirectionRight);

        assertThat(firstDirection).isEqualTo(Direction.of(false, firstDirectionRight));
        assertThat(nextDirection).isEqualTo(Direction.of(firstDirectionRight, nextDirectionRight));
    }
}
