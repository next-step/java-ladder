package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class DirectionTest {

    private int startIndex;
    private Direction leftDirection;
    private Direction rightDirection;

    @BeforeEach
    public void init(){
        startIndex = 3;
        leftDirection = Direction.of(true, false);
        rightDirection = Direction.of(false, true);
    }

    @DisplayName("isLeft 테스트")
    @Test
    void directionIsLeftTest(){
        assertThat(leftDirection.isLeft()).isTrue();
        assertThat(rightDirection.isLeft()).isFalse();
    }

    @DisplayName("isRight 테스트")
    @Test
    void directionIsRightTest(){
        assertThat(leftDirection.isRight()).isFalse();
        assertThat(rightDirection.isRight()).isTrue();
    }

    @DisplayName("Direction move index 테스트")
    @ParameterizedTest
    @CsvSource(value = {"true:false:2", "false:true:4", "false:false:3"}, delimiter = ':')
    void directionMoveIndexTest(boolean left, boolean right, int expect){

        Direction direction = Direction.of(left, right);

        assertThat(startIndex + direction.moveIndex()).isEqualTo(expect);

    }

    @DisplayName("Direction move index Exception 테스트")
    @Test
    void directionMoveIndexExceptionTest(){

        assertThatIllegalArgumentException().isThrownBy(() -> {

            Direction direction = Direction.of(true, true);
            direction.moveIndex();

        }).withMessageContaining("사다리 가로라인은 겹칠 수 없습니다.");

    }

}
