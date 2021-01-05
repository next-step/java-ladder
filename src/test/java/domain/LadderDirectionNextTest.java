package domain;

import ladder.domain.LadderDirection;
import ladder.domain.LadderDirectionNext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderDirectionNextTest {

    @Test
    @DisplayName("첫번재 point의 왼쪽 방향이 false인지")
    void checkFirstPoint(){
        LadderDirection direction = LadderDirectionNext.makeDirectionFirst();

        assertThat(false).isEqualTo(direction.isLeft());
    }


    @Test
    @DisplayName("마지막 point의 오른쪽 방향이 false인지")
    void checkLastPoint(){
        LadderDirection direction = new LadderDirection(true, false);
        direction.moveDistance();

        assertThat(false).isEqualTo(direction.isRight());
    }
}
