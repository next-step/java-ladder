package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사다리에서 이동할 방향 테스트")
public class DirectionTest {

    @DisplayName("왼쪽 방향 확인 테스트")
    @ParameterizedTest
    @CsvSource(value = {"false:true", "false:false", "true:false"}, delimiter = ':')
    public void isLeft(boolean expectedLeft, boolean expectedRight) {
        Direction direction = Direction.of(expectedLeft, expectedRight);

        boolean isLeft = direction.isLeft();

        assertThat(isLeft).isEqualTo(expectedLeft);
    }

    @DisplayName("오른쪽 방향 확인 테스트")
    @ParameterizedTest
    @CsvSource(value = {"false:true", "false:false", "true:false"}, delimiter = ':')
    public void isRight(boolean expectedLeft, boolean expectedRight) {
        Direction direction = Direction.of(expectedLeft, expectedRight);

        boolean isRight = direction.isRight();

        assertThat(isRight).isEqualTo(expectedRight);
    }

    @DisplayName("생성 불가한 방향")
    @Test
    public void invalidDirection() {
        assertThatThrownBy(() -> {
            Direction.of(true, true);
        }).isInstanceOf(InvalidDirectionException.class)
                .hasMessageContaining("양쪽 방향을 모두 가질수는 없습니다.");
    }

    @DisplayName("다음 방향 생성시 오른쪽 방향 유무")
    @ParameterizedTest
    @CsvSource(value = {"true:false:false", "false:true:false", "false:false:true"}, delimiter = ':')
    public void nextDirection(boolean currentRight, boolean isLast, boolean expectedNextRight) {
        Direction direction = Direction.of(false, currentRight);

        boolean isRight = direction.next(isLast, true).isRight();

        assertThat(isRight).isEqualTo(expectedNextRight);
    }

    @DisplayName("마지막 방향")
    @Test
    public void lastDirection() {
        Direction direction = Direction.last(true);
       
        boolean hasRight = direction.isRight();

        assertThat(hasRight).isEqualTo(false);
    }
}