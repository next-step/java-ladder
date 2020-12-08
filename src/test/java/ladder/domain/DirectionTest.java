package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static ladder.domain.LadderGameConfig.FIRST_INDEX;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class DirectionTest {

    @DisplayName("Direction 생성 테스트")
    @Test
    void directionConstructorTest(){

        Direction direction = new Direction(true, false);

        assertThat(direction.isLeft()).isTrue();
        assertThat(direction.isRight()).isFalse();
    }

    @DisplayName("Direction move index 테스트")
    @ParameterizedTest
    @CsvSource(value = {"true:false:-1", "false:true:1", "false:false:0"}, delimiter = ':')
    void directionMoveIndexTest(boolean left, boolean right, int expect){

        Direction direction = new Direction(left, right);

        assertThat(direction.moveIndex(FIRST_INDEX)).isEqualTo(expect);

    }

    @DisplayName("Direction move index Exception 테스트")
    @Test
    void directionMoveIndexExceptionTest(){

        assertThatIllegalArgumentException().isThrownBy(() -> {

            Direction direction = new Direction(true, true);
            direction.moveIndex(FIRST_INDEX);

        }).withMessageContaining(LadderGameErrorMessage.ILLEGAL_LINE_POINTS.getErrorMessage());

    }

}
