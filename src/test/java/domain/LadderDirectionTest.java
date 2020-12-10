package domain;

import ladder.domain.LadderDirection;
import ladder.util.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LadderDirectionTest {

    private LadderDirection LadderDirectionTest;

    @Test
    @DisplayName("양쪽에 사다리가 있는 경우 에러처리")
    void checkContinuityPoint(){
        assertThatThrownBy(() ->
                LadderDirectionTest = new LadderDirection(true, true)
        ).isInstanceOf(RuntimeException.class)
                .withFailMessage(ErrorMessage.getCheckInputLadderHeight());
    }

    @Test
    @DisplayName("왼쪽으로 이동하는지")
    void checkMoveLeft(){
        LadderDirectionTest = new LadderDirection(true, false);

        assertThat(LadderDirectionTest.isLeft()).isEqualTo(true);
    }

    @Test
    @DisplayName("오른쪽으로 이동하는지")
    void checkMoveRight(){
        LadderDirectionTest = new LadderDirection(false, true);

        assertThat(LadderDirectionTest.isRight()).isEqualTo(true);
    }
}
