package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.exceptions.InvalidDirectionParameterException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DirectionTests {
    @DisplayName("현재 위치와 오른쪽 위치에 다리 존재 여부를 입력받아서 객체 생성 가능")
    @ParameterizedTest
    @CsvSource(value = {"true:false", "false:true", "false:false"}, delimiter = ':')
    void createTest(boolean currentPointStatus, boolean nextPointStatus) {
        assertThat(new Direction(currentPointStatus, nextPointStatus)).isNotNull();
    }

    @DisplayName("현재 위치와 오른쪽의 위치가 모두 true로 생성 시도 시 예외 발생")
    @Test
    void createValidationTest() {
        assertThatThrownBy(() -> new Direction(true, true))
                .isInstanceOf(InvalidDirectionParameterException.class);
    }

    @DisplayName("현재 Direction을 기반으로 다음 Direction을 생성할 수 있다.")
    @Test
    void createNextDirection() {
        PointAddStrategy pointAddStrategy = new SimplePointAddStrategy();
        Direction initDirection = new Direction(false, true);

        Direction nextDirection = initDirection.next(pointAddStrategy);
        assertThat(nextDirection).isEqualTo(new Direction(true, false));

        Direction twoNextDirection = nextDirection.next(pointAddStrategy);
        assertThat(twoNextDirection).isEqualTo(new Direction(false, true));
    }

    @DisplayName("Direction 정책에 관계 없이 다음 Direction과 현재 Direction의 상태는 생성 즉시 고정된다.")
    @Test
    void directionCorrectTest() {
        PointAddStrategy randomStrategy = new RandomPointAddStrategy();
        Direction firstDirection = new Direction(false, true);
        Direction secondDirection = firstDirection.next(randomStrategy);

        for (int i = 0; i < 100; i++) {
            assertThat(firstDirection.getNextStatus()).isEqualTo(secondDirection.getCurrentStatus());
        }
    }
}
