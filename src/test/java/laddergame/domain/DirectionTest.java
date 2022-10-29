package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class DirectionTest {

    @DisplayName("오른쪽/왼쪽 방향 여부를 전달하면 해당하는 방향을 반환해야 한다.")
    @ParameterizedTest
    @CsvSource({
            "true,false,RIGHT",
            "false,true,LEFT",
            "false,false,NONE"
    })
    void of(boolean isRight, boolean isLeft, Direction expected) {
        assertThat(Direction.of(isRight, isLeft)).isEqualTo(expected);
    }

    @DisplayName("오른쪽이면서 동시에 왼쪽인 방향 여부를 전달하면 예외를 발생시켜야 한다.")
    @Test
    void of_givenBothRightAndLeft() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Direction.of(true, true));
    }

}
